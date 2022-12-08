package controller;
import Model.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * @Author Daniel Rajis
 */

public class Scene01controller {

    /**
     * Initialising First screen(Where we get user name) it's linked to
     * Scene01 fxml and receives user input and links to scene 02.
     */
    @FXML
    private AnchorPane scene01;

    /**
     * Variable used to hold the user's name
     */
    @FXML
    private TextField txtName;

    /**
     * @param event
     * @throws IOException
     *  @Description responsible for moving to scene02 from scene01.
     */
    @FXML
    void moveToNext(ActionEvent event) throws IOException {
        Data.setText(txtName.getText());
        AnchorPane scene02 = FXMLLoader.load(getClass().getResource("/fxml" +
                "/scene02.fxml"));
        scene01.getChildren().removeAll();
        scene01.getChildren().setAll(scene02);
    }

    /**
     * @param event
     * @Description Method responsible for Quitting the game from scene 01.
     */
    @FXML
    void quitProgram(ActionEvent event) {
        System.out.println("Bye!");
        System.exit(0);
    }

    /**
     * Method responsible for initialising data by getting user input and
     * setting it.
     */
    @FXML
    void initialize() {
        txtName.setText(Data.getText());

}}