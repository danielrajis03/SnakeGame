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
     * Scene01 fxml and receives user input and links to scene 02
     */
    @FXML
    private AnchorPane scene01;

    @FXML
    private TextField txtName;

    @FXML
    void moveToNext(ActionEvent event) throws IOException {
        Data.text = txtName.getText();
        AnchorPane scene02 = FXMLLoader.load(getClass().getResource("/fxml" +
                "/scene02.fxml"));
        scene01.getChildren().removeAll();
        scene01.getChildren().setAll(scene02);
    }

    @FXML
    void quitProgram(ActionEvent event) {
        System.out.println("Bye!");
        System.exit(0);
    }
    @FXML
    void initialize() {
        txtName.setText(Data.text);

}}