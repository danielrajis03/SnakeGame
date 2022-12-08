package Controller;

import GamePlay.Play;
import Model.Data;
import GameObjects.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * {@code @Description} Public class will have the actions for all of scene
 * 02 fxml and it is linked via the fx:id.
 * {@code @Author} Daniel Rajis
 *
 */
public class Scene02controller   {
    public static int SetbackGround;
    public static int speed;

    @FXML
    private AnchorPane scene02;


    @FXML
    private TextArea txaWelcome;

    /**
     * {@code @Description} Responsible for setting the background of the actual Snake
     * Gameplay
     */
    public static int getSetbackGround() {
        return SetbackGround;
    }

    public static void setSetbackGround(int setbackGround) {
        SetbackGround = setbackGround;
    }

    /**
     * {@code @Description} Variable used to represent the Speed of the Snake
     */
    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        Scene02controller.speed = speed;
    }


    /**
     * {@code @Description} Responsible for linking the "start game" button to the
     *       play class and starting the Game for the player.
     * @param event User clicks Start game button
     * @throws IOException throws IO exception
     *
     */
    @FXML
    void startGame(ActionEvent event)throws IOException {

        System.out.println("Game Started");
        getScene02().getChildren().removeAll();
        new Play().loadFrame();
        MusicPlayer.getMusicPlay("src/main/resources/frogger.mp3");



    }

    /**
     *  {@code @Description} Method responsible for setting the game background one.
     * @param event User clicks Background 1
     *
     */
    @FXML
    void BG1(ActionEvent event) {
        setSetbackGround(1);

    }

    /**
     * {@code @Description} Method responsible for setting the game background Two.
     * @param event User clicks Background 2 button.
     *
     */
    @FXML
    void BG2(ActionEvent event){
        setSetbackGround(2);}

    /**
     * @code @Description} Method responsible for setting the speed fo the snake for
     *       the easy level.
     * @param event User clicks Easy difficulty button
     *
     */
    @FXML
    void Easy(ActionEvent event) {
        setSpeed(5);
    }

    /**
     * {@code @Description} Method responsible for setting speed of the snake for
     *       the Hard level
     * @param event User clicks the hard difficulty button.
     *
     */
    @FXML
    void Hard(ActionEvent event) {
        setSpeed(9);
    }


    /**
     * {@code @Description} Method responsible for Displaying the welcome message on
     * screen two using the user input from "Data.getText()"
     */
    @FXML
    void initialize() {
        getTxaWelcome().setText("Welcome " + Data.getText());
    }

    /**
     * {@code @Description} Initialising Second screen where user selects level
     * difficulty and background of their round.
     */
    public AnchorPane getScene02() {
        return scene02;
    }

    public void setScene02(AnchorPane scene02) {
        this.scene02 = scene02;
    }

    /**
     * {@code @Description} Text displayed on scene two that outputs user input from
     * "Data.getText()"
     */
    public TextArea getTxaWelcome() {
        return txaWelcome;
    }

    public void setTxaWelcome(TextArea txaWelcome) {
        this.txaWelcome = txaWelcome;
    }
}





