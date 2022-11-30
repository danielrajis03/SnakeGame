package example;

import GamePlay.Play;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application  {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/scene01.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Snake Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


    /*@Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(Thread.currentThread().getName());
        primaryStage.setTitle("Snake Game");

        Button btn = new Button("Start Game");
        Button btn1 = new Button("End");
        StackPane root = new StackPane();
        Scene scene = new Scene(root,503,503);
        root.setId("stack-pane");


        btn.setOnAction(event -> {
            System.out.println("Game Started!");
            primaryStage.close();
            new Play().loadFrame();
            MusicPlayer.getMusicPlay("src/main/resources/frogger.mp3");

        });

        btn1.setOnAction(event -> {
            primaryStage.close();
            System.out.println("End");
        });
        btn.setTranslateX(0);
        btn1.setTranslateX(0);
        btn1.setTranslateY(150);
       //btn.setBackground(Background.fill(Color.CYAN));
        btn.setStyle("-fx-base: cyan;");
        btn1.setStyle("-fx-base: cyan;");


        root.getChildren().add(btn);
        root.getChildren().add(btn1);
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.getStylesheets().add("BG.css");
    }

    }
     */

