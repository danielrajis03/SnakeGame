package example;

import java.awt.Graphics;

public class Obstacles extends MyFrame.SnakeObject
{

    private static final long serialVersionUID = -3641221053272056036L;



    public Obstacles()	{
        this.l = true;
        // String.valueOf(new Random().nextInt(16))
        this.i = ImageUtil.images.get("Bomb.png");

        this.w = i.getWidth(null);
        this.h = i.getHeight(null);

        this.x = (int) (Math.random() * (870 - w + 10));
        this.y = (int) (Math.random() * (560 - h - 40));
    }

    public void hit(MyFrame.MySnake mySnake)	{

        if (mySnake.getRectangle().intersects(this.getRectangle()) && l && mySnake.l)		{
            this.l = false;
           // mySnake.changeLength(mySnake.getLength() + 1);
           // mySnake.score += 10;
        }
    }
    @Override
    public void draw(Graphics g)
    {
        g.drawImage(i, x, y, null);
    }
}

