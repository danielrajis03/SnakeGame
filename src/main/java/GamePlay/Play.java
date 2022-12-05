package GamePlay;

import example.Food;
import example.ImageUtil;
import example.MusicPlayer;
import example.MyFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.*;
/**
 * 
 * @Project Snake
 * @Description Spilaðu leikinn
 * @Author Sigurður Sigurðardóttir
 * @version Ekki viss
 */ 

public class Play extends MyFrame
{

	private static final long serialVersionUID = -3641221053272056036L;

	public MySnake mySnake = new MySnake(100, 100);// x , y
	public Food food = new Food();

	public Image background = ImageUtil.images.get("UI-background");
	public Image fail = ImageUtil.images.get("game-scene-01");
	public String highScore = "";

	@Override
	public void keyPressed(KeyEvent e)
	{
		super.keyPressed(e);
		mySnake.keyPressed(e);
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		if(highScore.equals("")){
			highScore = this.GetHighScore();
		}
		g.drawImage(background, 0, 0, null);

		// Ákveða stöðu leiksins.
		if (mySnake.l)
		{
			mySnake.draw(g);
			if (food.l)
			{
				food.draw(g);
				food.eaten(mySnake);
			} else
			{
				food = new Food();
			}
		} else
		{
			g.drawImage(fail, 0, 0, null);
		}
		drawScore(g);
	}

	public void drawScore(Graphics g)
	{
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		g.setColor(Color.MAGENTA);
		g.drawString("SCORE : " + mySnake.score, 20, 40);
		g.drawString("HighScore : " + highScore, 20, 65);
	}

	public static void main(String[] args)
	{
		new Play().loadFrame();
		MusicPlayer.getMusicPlay("src/main/resources/frogger.mp3");

	}
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
		return "0";
	}
		finally{
			try { if (reader != null)
				reader.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		}



/*	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		// frame.setSize(400,600);
		frame.setBounds(450, 200, 920, 600);
		// frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SnakePanel panel = new SnakePanel();
		frame.add(panel);

		frame.setVisible(true);

		// Play the background music.
		MusicPlayer.getMusicPlay("resource\\music\\background.mp3");
	} 
*/
}
