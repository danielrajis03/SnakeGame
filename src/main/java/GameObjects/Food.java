package GameObjects;

import java.awt.Graphics;
import java.util.Random;
/**
 * @author Daniel Rajis
 */


public class Food extends MyFrame.SnakeObject
{

	private static final long serialVersionUID = -3641221053272056036L;


	/**
	 * Method responsible for the random spawning of the fruit and making
	 * sure it is within bounds and continues whilst the snake is true.
	 */
	public Food()	{
		this.setL(true);

	this.setI(ImageUtil.getImages().get(String.valueOf(new Random().nextInt(16))));

		this.setW(getI().getWidth(null));
		this.setH(getI().getHeight(null));

		this.setX((int) (Math.random() * (870 - getW() + 10)));
		this.setY((int) (Math.random() * (560 - getH() - 40)));
	}

	/**
	 * @param mySnake
	 * @Description Method responsible for what happens after a fruit is "eaten"
	 * by the
	 * snake.
	 */
	public void eaten(MyFrame.MySnake mySnake)	{

		if (mySnake.getRectangle().intersects(this.getRectangle()) && isL() &&
				mySnake.isL())		{
			this.setL(false);
			mySnake.changeLength(mySnake.getLength() + 1);
			mySnake.setScore(mySnake.getScore() + 100);
		}
	}

	/**
	 * @param g
	 * @Description Responsible for the drawing of images.
	 * Draws as much of the specified image as is currently available.
	 * The image is drawn with its top-left corner at (x, y).In this
	 * graphics context's coordinate space.
	 */
	@Override
	public void draw(Graphics g)
	{
		g.drawImage(getI(), getX(), getY(), null);
	}
}
