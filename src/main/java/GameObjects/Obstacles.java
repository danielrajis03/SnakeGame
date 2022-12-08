package GameObjects;

import java.awt.Graphics;
import java.util.Random;

public class Obstacles extends MyFrame.SnakeObject
{


    /**
     * The obstacles method will randomly spawn either bomb or wall images
     * within the
     * bound.
     */
    public Obstacles()	{
        this.setL(true);

        this.setI(ImageUtil.getImages().get(String.valueOf(new Random().nextInt(17,19))));

        this.setW(getI().getWidth(null));
        this.setH(getI().getHeight(null));

        this.setX((int) (Math.random() * (870 - getW() + 10)));
        this.setY((int) (Math.random() * (560 - getH() - 40)));
    }


    /**
     * @param mySnake Body of snake
     * {@code @Description} Collides will kill the snake and end the game if the
     * snake overlaps with the obstacle images.
     */
    public void collides(MyFrame.MySnake mySnake)	{

        if (mySnake.getRectangle().intersects(this.getRectangle()) && isL() && mySnake.isL())		{
            mySnake.setL(false);

        }
    }

    /**
     * @param g g
     */
    @Override
    public void draw(Graphics g)
    {
        g.drawImage(getI(), getX(), getY(), null);
    }
}

