package example;


import java.awt.Graphics;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Image;

public class Poison extends MyFrame.SnakeObject
{

    private static final long serialVersionUID = -3641221053272056036L;



    public Poison ()	{
        this.l = true;

        this.i = ImageUtil.images.get(String.valueOf(new Random().nextInt(19,21)));

        this.w = i.getWidth(null);
        this.h = i.getHeight(null);

        this.x = (int) (Math.random() * (870 - w + 10));
        this.y = (int) (Math.random() * (560 - h - 40));
    }

    public void poisons(MyFrame.MySnake mySnake)	{

        if (mySnake.getRectangle().intersects(this.getRectangle()) && l && mySnake.l)		{
            mySnake.score -= 10;
            this.l = false;
        }
    }
    @Override
    public void draw(Graphics g)
    {
        g.drawImage(i, x, y, null);
    }
}
