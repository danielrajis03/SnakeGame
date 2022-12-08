package gameObjects;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.fxml.FXMLLoader;


public class Main extends Application  {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/scene01.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Snake Game");
        stage.setScene(scene);
        stage.show();
    }
    public static String playerName;
    public static void main(String[] args) {
        launch();
    }
}


