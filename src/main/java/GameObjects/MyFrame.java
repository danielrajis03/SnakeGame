package GameObjects;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import static GamePlay.Play.CheckScore;
import static controller.Scene02controller.speed;


/**
 *
 * @Author Sigurður Sigurðardóttir and Daniel Rajis

 */ 


public class MyFrame extends JPanel implements KeyListener
{
	private static final long serialVersionUID = -3149926831770554380L;

	public JFrame jFrame = new JFrame();

	/**
	 * method that is implemented wherever the snake logo is to be used.
	 */
	public MyFrame()
	{
		jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("snake-logo.png"));
	}

	/**
	 * @Description Method Responsible for loading the frame in which the
	 * actual
	 * snake game is played
	 */
	public void loadFrame()
	{


		this.setDoubleBuffered(true);
		jFrame.add(this);
		jFrame.addKeyListener(this);

		jFrame.setTitle("D1's Snake Game");
		jFrame.setSize(870, 560);
		jFrame.setLocationRelativeTo(null);
		jFrame.addWindowListener(new WindowAdapter()// loka
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				System.exit(0);
			}
		});
		jFrame.setVisible(true);

		new MyThread().start();
	}
	class MyThread extends Thread
	{
		@Override
		public void run()
		{
			super.run();
			while (true)
			{
				repaint();
				try
				{
					sleep(30);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * Public Class that implements methods that entail how the snake
	 * interacts with other game objects and how it effects the score.
	 */
	public static class MySnake extends SnakeObject implements movable
	{

		/**
		 *
		 */
		private int speed_XY;
		/**
		 * Initialisation of the variable for the length of the snake.
		 */
		private int length;
		private int num;
		/**
		 * Initialisation of the variable for the score
		 */
		private int score = 0;

		/**
		 * Variable holding the image of the Snake's Head
		 */
		private static final BufferedImage IMG_SNAKE_HEAD =
			(BufferedImage) ImageUtil.getImages().get("snake-head-right");

		private static List<Point> bodyPoints = new LinkedList<>();

		private static BufferedImage newImgSnakeHead;
		boolean up, down, left, right = true;

		/**
		 * @param x
		 * @param y
		 * Represents the body of the snake. Method used to initialise its
		 * length and image.
		 */
		public MySnake(int x, int y)
		{
			this.setL(true);
			this.setX(x);
			this.setY(y);
			this.setI(ImageUtil.getImages().get("snake-body"));
			this.setW(getI().getWidth(null));
			this.setH(getI().getHeight(null));

			this.setSpeed_XY(speed);
			this.setLength(1);

			/*
			 * Attention : ?
			 */
			this.setNum(getW() / getSpeed_XY());
			setNewImgSnakeHead(getImgSnakeHead());

		}

		public static BufferedImage getImgSnakeHead() {
			return IMG_SNAKE_HEAD;
		}

		public static List<Point> getBodyPoints() {
			return bodyPoints;
		}

		public static void setBodyPoints(List<Point> bodyPoints) {
			MySnake.bodyPoints = bodyPoints;
		}

		public static BufferedImage getNewImgSnakeHead() {
			return newImgSnakeHead;
		}

		public static void setNewImgSnakeHead(BufferedImage newImgSnakeHead) {
			MySnake.newImgSnakeHead = newImgSnakeHead;
		}

		public int getLength()
		{
			return length;
		}

		public void changeLength(int length)
		{
			this.setLength(length);
		}

		public void keyPressed(KeyEvent e)
		{
			/**
			 * @Author athugaðu lykilinn and Daniel Rajis
 			 */

			switch (e.getKeyCode())
			{
			case KeyEvent.VK_UP:
				if (!down)
				{
					up = true;
					down = false;
					left = false;
					right = false;

					setNewImgSnakeHead((BufferedImage) GameUtil.rotateImage(getImgSnakeHead(), -90));
				}
				break;

			case KeyEvent.VK_DOWN:
				if (!up)
				{
					up = false;
					down = true;
					left = false;
					right = false;

					setNewImgSnakeHead((BufferedImage) GameUtil.rotateImage(getImgSnakeHead(), 90));
				}
				break;

			case KeyEvent.VK_LEFT:
				if (!right)
				{
					up = false;
					down = false;
					left = true;
					right = false;

					setNewImgSnakeHead((BufferedImage) GameUtil.rotateImage(getImgSnakeHead(), -180));

				}
				break;

			case KeyEvent.VK_RIGHT:
				if (!left)
				{
					up = false;
					down = false;
					left = false;
					right = true;

					setNewImgSnakeHead(getImgSnakeHead());
				}

			default:
				break;
			}
		}


		public void move()
		{
			/**
			 * @Author láta kvikindið hreyfa sig and Daniel Rajis
			 */

			if (up)
			{
				setY(getY() - getSpeed_XY());
			} else if (down)
			{
				setY(getY() + getSpeed_XY());
			} else if (left)
			{
				setX(getX() - getSpeed_XY());
			} else if (right)
			{
				setX(getX() + getSpeed_XY());
			}

		}

		@Override
		public void draw(Graphics g)
		{

			outOfBounds();

			eatBody();

			getBodyPoints().add(new Point(getX(), getY()));

			if (getBodyPoints().size() == (this.getLength() + 1) * getNum())
			{
				getBodyPoints().remove(0);
			}
			g.drawImage(getNewImgSnakeHead(), getX(), getY(), null);
			drawBody(g);

			move();
		}

		public void eatBody()
		{
			for (Point point : getBodyPoints())
			{
				for (Point point2 : getBodyPoints())
				{
					if (point.equals(point2) && point != point2)
					{
						this.setL(false);
						CheckScore();
					}
				}
			}
		}

		public void drawBody(Graphics g)
		{
			int length = getBodyPoints().size() - 1 - getNum();

			for (int i = length; i >= getNum(); i -= getNum())
			{
				Point point = getBodyPoints().get(i);
				g.drawImage(this.getI(), point.x, point.y, null);
			}
		}

		private void outOfBounds()
		{
			boolean xOut = (getX() <= 0 || getX() >= (870 - getW()));
			boolean yOut = (getY() <= 0 || getY() >= (560 - getH()));
			if (xOut || yOut)
			{
				setL(false);
				CheckScore();
			}
		}

		/**
		 * @return speed_XY
		 */
		public int getSpeed_XY() {
			return speed_XY;
		}

		/**
		 * @param speed_XY
		 */
		public void setSpeed_XY(int speed_XY) {
			this.speed_XY = speed_XY;
		}

		public void setLength(int length) {
			this.length = length;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		/**
		 * Gets Variable holding the score of the user
		 */
		public int getScore() {
			return score;
		}

		/**
		 * @param score
		 * @Description Assigns Variable score
		 */
		public void setScore(int score) {
			this.score = score;
		}
	}

	public abstract static class SnakeObject
	{
		private int x;
		private int y;
		private Image i;
		private int w;
		private int h;

		private boolean l;


		public abstract void draw(Graphics g);

		/**
		 * @return coordinates of the rectangle
		 * @Description Gets the with and height of rectangle
		 */
		public Rectangle getRectangle()
		{
			return new Rectangle(getX(), getY(), getW(), getH());
		}

		/**
		 * @return x
		 */
		public int getX() {
			return x;
		}

		/**
		 * @param x
		 */
		public void setX(int x) {
			this.x = x;
		}

		/**
		 * @return y
		 */
		public int getY() {
			return y;
		}

		/**
		 * @param y
		 */
		public void setY(int y) {
			this.y = y;
		}

		/**
		 * @return I
		 */
		public Image getI() {
			return i;
		}

		/**
		 * @param i
		 */
		public void setI(Image i) {
			this.i = i;
		}

		/**
		 * @return w
		 */
		public int getW() {
			return w;
		}

		/**
		 * @param w
		 */
		public void setW(int w) {
			this.w = w;
		}

		/**
		 * @return h
		 */
		public int getH() {
			return h;
		}

		/**
		 * @param h
		 */
		public void setH(int h) {
			this.h = h;
		}

		/**
		 * @return l
		 */
		public boolean isL() {
			return l;
		}

		/**
		 * @param l
		 */
		public void setL(boolean l) {
			this.l = l;
		}
	}
}
