package GameObjects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;


/**
 *Images are put into buffers and stored where they can be called and/or
 * manipulated
 */
public class GameUtil
{
	/**
	 * @param imagePath image path in directory
	 * @return i
	 */
	public static Image getImage(String imagePath)
	{
		URL u = GameUtil.class.getClassLoader().getResource(imagePath);
		BufferedImage i = null;
		try
		{
			i = ImageIO.read(u);
		} catch (Exception e)
		{
			System.err.println(" Error !\n");
			e.printStackTrace();
		}

		return i;
	}

	/**
	 *
	 * {@code @Description} Rotates image certain amount of degrees.
	 * @return i
	 *
	 */
	public static Image rotateImage(final BufferedImage bufferedImage,
									 final int degree)
	{
	int w = bufferedImage.getWidth();
	int h = bufferedImage.getHeight();
	int t = bufferedImage.getColorModel().getTransparency();

	BufferedImage i;
	Graphics2D graphics2d;

	(graphics2d = (i = new BufferedImage(w, h, t)).createGraphics())
		.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
			RenderingHints.VALUE_INTERPOLATION_BILINEAR);

	graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
	graphics2d.drawImage(bufferedImage, 0, 0, null);
	graphics2d.dispose();

	return i;

	}
}
