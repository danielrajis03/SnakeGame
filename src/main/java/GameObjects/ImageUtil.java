package GameObjects;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

/**
 *  Class responsible for the storing of images that can be fetched
 * and used within the game.
 */
public class ImageUtil
{
	/**
	 *  Variable that is placeholder of images that can be
	 * fetched with "getImages"
	 */
	private static Map<String, Image> images = new HashMap<>();

	static
	{
		// snake
		getImages().put("snake-head-right", GameUtil.getImage("snake-head-right.png"));
		getImages().put("snake-body", GameUtil.getImage("snake-body.png"));
		// obstacles
		getImages().put("0", GameUtil.getImage("food-kiwi.png"));
		getImages().put("1", GameUtil.getImage("food-lemon.png"));
		getImages().put("2", GameUtil.getImage("food-litchi.png"));
		getImages().put("3", GameUtil.getImage("food-mango.png"));
		getImages().put("4", GameUtil.getImage("food-apple.png"));
		getImages().put("5", GameUtil.getImage("food-banana.png"));
		getImages().put("6", GameUtil.getImage("food-blueberry.png"));
		getImages().put("7", GameUtil.getImage("food-cherry.png"));
		getImages().put("8", GameUtil.getImage("food-durian.png"));
		getImages().put("9", GameUtil.getImage("food-grape.png"));
		getImages().put("10", GameUtil.getImage("food-grapefruit.png"));
		getImages().put("11", GameUtil.getImage("food-peach.png"));
		getImages().put("12", GameUtil.getImage("food-pear.png"));
		getImages().put("13", GameUtil.getImage("food-orange.png"));
		getImages().put("14", GameUtil.getImage("food-pineapple.png"));
		getImages().put("15", GameUtil.getImage("food-strawberry.png"));
		getImages().put("16", GameUtil.getImage("food-watermelon.png"));
		getImages().put("17", GameUtil.getImage("bombuse.png"));
		getImages().put("18", GameUtil.getImage("walluse.png"));
		getImages().put("19", GameUtil.getImage("poison 1.png"));
		getImages().put("20", GameUtil.getImage("poison 2.png"));
		getImages().put("UI-background", GameUtil.getImage("UI-background.png"));
		getImages().put("game-scene-01", GameUtil.getImage("game-scene-01.jpg"));
		getImages().put("UI-background2", GameUtil.getImage("UI-background2.png"));

	}

	/**
	 * @return images
	 */
	public static Map<String, Image> getImages() {
		return images;
	}

}
