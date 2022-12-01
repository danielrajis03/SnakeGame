package controller;

import GamePlay.Play;
import example.Main;
import com.example.snake.model.Data;
import example.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
public class Scene02controller   {

    @FXML
    private AnchorPane scene02;

    @FXML
    private AnchorPane scene01;

    @FXML
    private TextArea txaWelcome;

    @FXML
    void sayBye(ActionEvent event)throws IOException {
        AnchorPane scene01 = FXMLLoader.load(Main.class.getClass().getResource("fxml/scene01.fxml"));
        scene02.getChildren().removeAll();
        scene02.getChildren().setAll(scene01);
    }

    @FXML
    void startGame(ActionEvent event) throws IOException {
        scene02.getChildren().removeAll();
        System.out.println("Game Started");
        new Play().loadFrame();
        MusicPlayer.getMusicPlay("src/main/resources/frogger.mp3");
        System.exit(0);


    }

    @FXML
    void initialize() {
        txaWelcome.setText("Welcome " + Data.text);
    }
}





