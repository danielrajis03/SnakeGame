package Controller;
import Model.Data;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


/**
 *Public Class for Scene 01 controller that controls the fxml of scene 01 and
 *  all that it does.
 */
public class Scene01controller {

    @FXML
    private AnchorPane scene01;

    @FXML
    private TextField txtName;

    /**
     * responsible for moving to scene02 from scene01.
     * @throws IOException in case of error
     *
     */
    @FXML
    void moveToNext() throws IOException {
        Data.setText(getTxtName().getText());
        AnchorPane scene02 = FXMLLoader.load(getClass().getResource("/fxml" +
                "/scene02.fxml"));
        getScene01().getChildren().removeAll();
        getScene01().getChildren().setAll(scene02);
    }

    /**
     */
    @FXML
    void quitProgram() {
        System.out.println("Bye!");
        System.exit(0);
    }

    /**
     * Method responsible for initialising data by getting user input and
     * setting it.
     */
    @FXML
    void initialize() {
        getTxtName().setText(Data.getText());

}

    /**
     * Initialising First screen(Where we get username) it's linked to
     * Scene01 fxml and receives user input and links to scene 02.
     */
    public AnchorPane getScene01() {
        return scene01;
    }

    /**
     * @param scene01  Scene 01
     */
    public void setScene01(AnchorPane scene01) {
        this.scene01 = scene01;
    }

    /**
     * Variable used to hold the user's name
     */
    public TextField getTxtName() {
        return txtName;
    }

    public void setTxtName(TextField txtName) {
        this.txtName = txtName;
    }
}