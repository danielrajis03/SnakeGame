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
     * @Description Variable used to represent the Speed of the Snake
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
     * @param event User clicks Start game button
     * @throws IOException
     * @Description Responsible for linking the "start game" button to the
     * play class and starting the Game for the player.
     */
    @FXML
    void startGame(ActionEvent event)throws IOException {

        System.out.println("Game Started");
        scene02.getChildren().removeAll();
        new Play().loadFrame();
        MusicPlayer.getMusicPlay("src/main/resources/frogger.mp3");



    }

    /**
     * @param event User clicks Background 1
     * @Description Method responsible for setting the game background one.
     */
    @FXML
    void BG1(ActionEvent event) {
        SetbackGround =1;

    }

    /**
     * @param event User clicks Background 2 button.
     * @Description Method responsible for setting the game background Two.
     */
    @FXML
    void BG2(ActionEvent event){
        SetbackGround = 2;}

    /**
     * @param event User clicks Easy difficulty button
     * @Description Method responsible for setting the speed fo the snake for
     * the easy level.
     */
    @FXML
    void Easy(ActionEvent event) {
        speed = 5;
    }

    /**
     * @param event User clicks the hard difficulty button.
     * @Description Method responsible for setting speed of the snake for
     * the Hard level
     */
    @FXML
    void Hard(ActionEvent event) {
        speed = 9;
    }


    /**
     * @Description Method responsible for Displaying the welcome medssage on
     * screen two using the user input from "Data.getText()"
     */
    @FXML
    void initialize() {
        txaWelcome.setText("Welcome " + Data.getText());
    }
}





