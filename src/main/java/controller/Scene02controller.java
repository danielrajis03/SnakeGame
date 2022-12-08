package controller;

import GamePlay.Play;
import Model.Data;
import GameObjects.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * @Author Daniel Rajis
 */
public class Scene02controller   {
    /**
     * @Description Responsible for setting the background of the actual Snake
     * Gameplay
     */
    public static int SetbackGround;
    /**
     * @Description Variable used to set the Speed of the Snake
     */
    public static int speed;

    /**
     * @Description Initialising Second screen where user selects level
     * difficulty and background of their round.
     */
    @FXML
    private AnchorPane scene02;


    /**
     * @Description Text displayed on scene two that outputs user input from
     * "Data.getText()"
     */
    @FXML
    private TextArea txaWelcome;


    /**
     * @param event
     * @throws IOException
     * @Description
     */
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




    @FXML
    void initialize() {
        txaWelcome.setText("Welcome " + Data.getText());
    }
}





