package GameObjects;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.fxml.FXMLLoader;



public class Main extends Application  {
    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String playerName) {
        Main.playerName = playerName;
    }

    /**
     * @param stage
     * @throws IOException
     * @Description Method responsible for the booting up of the first scene
     * by loading it using fxml and setting up the screen and Title
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/scene01.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Snake Game");
        stage.setScene(scene);
        stage.show();
    }
    public static String playerName;

    /**
     * @param args
     * Responsible for the running of the program.
     */
    public static void main(String[] args) {
        launch();
    }
}


