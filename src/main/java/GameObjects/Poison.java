package GameObjects;


import java.awt.Graphics;
import java.util.Random;

public class Poison extends MyFrame.SnakeObject
{

    private static final long serialVersionUID = -3641221053272056036L;



    public Poison ()	{
        this.setL(true);

        this.setI(ImageUtil.getImages().get(String.valueOf(new Random().nextInt(19,21))));

        this.setW(getI().getWidth(null));
        this.setH(getI().getHeight(null));

        this.setX((int) (Math.random() * (870 - getW() + 10)));
        this.setY((int) (Math.random() * (560 - getH() - 40)));
    }

    public void poisons(MyFrame.MySnake mySnake)	{

        if (mySnake.getRectangle().intersects(this.getRectangle()) && isL() && mySnake.isL())		{
            mySnake.setScore(mySnake.getScore() - 10);
            this.setL(false);
        }
    }
    @Override
    public void draw(Graphics g)
    {
        g.drawImage(getI(), getX(), getY(), null);
    }
}
