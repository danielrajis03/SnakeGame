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
 * @Project Snakee
 * @Description Hladdu leikinn og endurnýjaðu hann stöðugt
 * @Author Sigurður Sigurðardóttir
 * @version Ekki viss
 */ 


public class MyFrame extends JPanel implements KeyListener
{
	private static final long serialVersionUID = -3149926831770554380L;

	public JFrame jFrame = new JFrame();

	public MyFrame()
	{
		jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("snake-logo.png"));
	}

	public void loadFrame()
	{
		/*
		 * Komið í veg fyrir að myndin blikki.
		 */
		this.setDoubleBuffered(true);
		jFrame.add(this);
		jFrame.addKeyListener(this);

		jFrame.setTitle("Snakee Yipee");
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

	public static class MySnake extends SnakeObject implements movable
	{
		// Leikjabreytan.
		private int speed_XY;
		private int length;
		private int num; // ?
		private int score = 0;

		//

		private static final BufferedImage IMG_SNAKE_HEAD = (BufferedImage) ImageUtil.images.get("snake-head-right");

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
			this.l = true;
			this.x = x;
			this.y = y;
			this.i = ImageUtil.images.get("snake-body");
			this.w = i.getWidth(null);
			this.h = i.getHeight(null);

			this.setSpeed_XY(speed);
			this.setLength(1);

			/*
			 * Attention : ?
			 */
			this.setNum(w / getSpeed_XY());
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
				y -= getSpeed_XY();
			} else if (down)
			{
				y += getSpeed_XY();
			} else if (left)
			{
				x -= getSpeed_XY();
			} else if (right)
			{
				x += getSpeed_XY();
			}

		}

		@Override
		public void draw(Graphics g)
		{

			outofBounds();

			eatBody();

			getBodyPoints().add(new Point(x, y));

			if (getBodyPoints().size() == (this.getLength() + 1) * getNum())
			{
				getBodyPoints().remove(0);
			}
			g.drawImage(getNewImgSnakeHead(), x, y, null);
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
						this.l = false;
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
				g.drawImage(this.i, point.x, point.y, null);
			}
		}

		private void outofBounds()
		{
			boolean xOut = (x <= 0 || x >= (870 - w));
			boolean yOut = (y <= 0 || y >= (560 - h));
			if (xOut || yOut)
			{
				l = false;
				CheckScore();
			}
		}

		public int getSpeed_XY() {
			return speed_XY;
		}

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
		 * Variable holding the score of the user
		 */
		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
	}

	public abstract static class SnakeObject
	{
		int x;
		int y;
		Image i;
		int w;
		int h;

		public boolean l;


		public abstract void draw(Graphics g);

		public Rectangle getRectangle()
		{
			return new Rectangle(x, y, w, h);
		}
	}
}
