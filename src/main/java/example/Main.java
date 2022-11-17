package example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.*;



public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(Thread.currentThread().getName());
        primaryStage.setTitle("Snake Game");

        Button btn = new Button("Start Game");
        Button btn1 = new Button("End");



        btn.setOnAction(event -> {
            System.out.println("Game Started!");
            primaryStage.close();
            new Play().loadFrame();

        });

        btn1.setOnAction(event -> {
            primaryStage.close();
            System.out.println("End");
        });
        btn.setTranslateX(0);
        btn1.setTranslateX(0);
        btn1.setTranslateY(150);
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(btn1);
        primaryStage.setScene(new Scene(root, 640, 800));
        primaryStage.show();

    }
}