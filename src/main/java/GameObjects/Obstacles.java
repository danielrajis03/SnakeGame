package GameObjects;

import java.awt.Graphics;
import java.util.Random;

public class Obstacles extends MyFrame.SnakeObject
{

    private static final long serialVersionUID = -3641221053272056036L;



    public Obstacles()	{
        this.setL(true);
        // String.valueOf(new Random().nextInt(16))
        this.setI(ImageUtil.getImages().get(String.valueOf(new Random().nextInt(17,19))));

        this.setW(getI().getWidth(null));
        this.setH(getI().getHeight(null));

        this.setX((int) (Math.random() * (870 - getW() + 10)));
        this.setY((int) (Math.random() * (560 - getH() - 40)));
    }

    public void collides(MyFrame.MySnake mySnake)	{

        if (mySnake.getRectangle().intersects(this.getRectangle()) && isL() && mySnake.isL())		{
            mySnake.setL(false);
           // mySnake.changeLength(mySnake.getLength() + 1);
           // mySnake.score += 10;
        }
    }
    @Override
    public void draw(Graphics g)
    {
        g.drawImage(getI(), getX(), getY(), null);
    }
}

