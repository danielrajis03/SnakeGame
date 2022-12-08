package GamePlay;

import Model.Data;
import GameObjects.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.*;
import static GameObjects.Main.playerName;
import static Controller.Scene02controller.SetbackGround;

/**
 * 
 * {@code @Project} Snake
 * {@code @Description} A Snake Game implemented using Java FX.
 * {@code @Author} Daniel Rajis
 */

public class Play extends MyFrame
{

	@Serial
	private static final long serialVersionUID = -3641221053272056036L;

	public static MySnake mySnake = new MySnake(100, 100);// x , y
	/**
	 * Variable food representing the images of the fruit in the game and how
	 * they interact with other objects such as the snake
	 */
	public Food food = new Food();
	/**
	 * Obstacles is the variable that represents the wall and bombs and how
	 * they interact with other objects such as the snake.
	 */
	public Obstacles obstacles = new Obstacles();
	/**
	 * Poison is the variable that represents the poison images and how
	 * 	  they interact with other objects such as the snake.
	 */
	public Poison poison = new Poison();


	/**
	 * Variable that holds the background and any image currently assigned to
	 * it.
	 */
	public Image background = ImageUtil.getImages().get("UI-background");
	/**
	 * Variable for the screen if the game ends.
	 */
	public Image fail = ImageUtil.getImages().get("game-scene-01");
	/**
	 * highscore is a string variable that will hold the highscore in format
	 * "name:score"
	 */
	public static String highScore = "";


	@Override
	public void keyPressed(KeyEvent e)
	{
		super.keyPressed(e);
		mySnake.keyPressed(e);
	}

	/**
	 * {@code @Description} Paint is the method that implements the setting of
	 * 	  background choice, the spawning of food,obstacles and poison and the
	 * 	  fetching and printing of the highscore.
	 * @param g the <code>Graphics</code> context in which to paint
	 *
	 */
	@Override
	public void paint(Graphics g)
	{
		if(SetbackGround ==1){
			background = ImageUtil.getImages().get("UI-background");
		}
		if (SetbackGround ==2){
			background = ImageUtil.getImages().get("UI-background2");
		}
		super.paint(g);
		if(highScore.equals("")){
			highScore = this.GetHighScore();
		}
		if (playerName == null){
			playerName = Data.getText();
		}

		g.drawImage(background, 0, 0, null);

		if (mySnake.isL())
		{
			mySnake.draw(g);
			if (food.isL())
			{
				food.draw(g);
				food.eaten(mySnake);
			} else
			{
				food = new Food();
				obstacles = new Obstacles();
				poison = new Poison();
			}
		} else
		{
			g.drawImage(fail, 115, 100, null);
		}
		if (obstacles.isL())
		{
			obstacles.draw(g);
			obstacles.collides(mySnake);
			CheckScore();
		}
		if(poison.isL()){
			poison.draw(g);
			poison.poisons(mySnake);
			CheckScore();
		}
		drawScore(g);


	}

	/**
	 * {@code @Description} The method for drawing the Name of the user along with
	 * 	  their
	 * 	  current and highscore
	 * @param g g
	 *
	 */
	public void drawScore(Graphics g)
	{
		CheckScore();
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		g.setColor(Color.MAGENTA);
		g.drawString("SCORE : " + mySnake.getScore(), 250, 40);
		g.drawString("NAME : " + Data.getText(), 20, 40);
		g.drawString("HIGH SCORE : " + highScore, 20, 68);
	}


	/**
	 * Checks to see if the current score is higher than the current
	 * highscore and then sets the format of the highscore.dat file and
	 * assigns a new highscore
	 * to the file once the user sets a new record
	 */
	public static void CheckScore(){
		//format Daniel/:/100
		if (mySnake.getScore() > Integer.parseInt((highScore.split(":")[1]))){
			//user set new record
			highScore = playerName + ":" + mySnake.getScore();
			File scoreFile = new File("highscore.dat");
			if (!scoreFile.exists()){
				try{
					scoreFile.createNewFile();
				}
				catch (IOException e){
					throw new RuntimeException(e);
				}
			}
			BufferedWriter bWriter = null;
			FileWriter writeFile = null ;
			try {
				writeFile = new FileWriter(scoreFile);
				bWriter = new BufferedWriter(writeFile);
				bWriter.write(highScore+"\n");
			}
			catch (Exception e){
				throw new RuntimeException();
			}
			finally{
				try{
					if(bWriter!= null)
						bWriter.close();
				}
				catch (Exception e){
					//errors
				}
			}
		}

}
	public static void main(String[] args)
	{
		new Play().loadFrame();
		MusicPlayer.getMusicPlay("src/main/resources/frogger.mp3");

	}

	/**
	 * {@code @Description} Method responsible for fetching the
	 * highscore from the
	 * highscore.dat file
	 */
	public String GetHighScore()
	{
		//format:  Daniel:100
		FileReader readFile = null;
		BufferedReader reader = null;
		try {
			 readFile = new FileReader("highscore.dat");
			 reader = new BufferedReader(readFile);
			return reader.readLine();
		}
		catch(Exception e)
		{
		return "Nobody:0";
	}
		finally{
			try { if (reader != null)
				reader.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		}




}
