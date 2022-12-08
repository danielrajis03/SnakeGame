package Model;
/**
 * @author Daniel Rajis
 */


public class Data {

    private static String text ="";

    /**
     * Collects user input(specifically name from main menu)
     * It is called in Play class to be used to display user highscore.
     */
    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        Data.text = text;
    }
}
