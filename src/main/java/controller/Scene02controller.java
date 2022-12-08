package controller;

import GamePlay.Play;
import com.example.snake.model.Data;
import gameObjects.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Scene02controller   {
    public static int SetbackGround;
    public static int speed;

    @FXML
    private AnchorPane scene02;

   /* @FXML
    private AnchorPane scene01;*/

    @FXML
    private TextArea txaWelcome;



    @FXML
    void startGame(ActionEvent event)throws IOException {

        System.out.println("Game Started");
        scene02.getChildren().removeAll();
        new Play().loadFrame();
        MusicPlayer.getMusicPlay("src/main/resources/frogger.mp3");



    }
    @FXML
    void BG1(ActionEvent event) {
        SetbackGround =1;

    }

    @FXML
    void BG2(ActionEvent event){
        SetbackGround = 2;}

    @FXML
    void Easy(ActionEvent event) {
        speed = 5;
    }

    @FXML
    void Hard(ActionEvent event) {
        speed = 9;
    }


   /* @FXML
    void sayBye(ActionEvent event)throws IOException {
        AnchorPane scene01 = FXMLLoader.load(Main.class.getClass().getResource("fxml/scene01.fxml"));
        scene02.getChildren().removeAll();
        scene02.getChildren().setAll(scene01);
    }*/

    @FXML
    void initialize() {
        txaWelcome.setText("Welcome " + Data.text);
    }
}





