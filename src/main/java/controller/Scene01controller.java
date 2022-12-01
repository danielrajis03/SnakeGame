package controller;
import GamePlay.Play;
import example.Main;
import com.example.snake.model.Data;
import example.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Scene01controller {
    @FXML
    private AnchorPane scene01;

    @FXML
    private TextField txtName;

    @FXML
    void moveToNextScene(ActionEvent event) throws IOException {
        Data.text = txtName.getText();
        AnchorPane scene02 = FXMLLoader.load(Main.class.getClass().getResource("fxml/scene02.fxml"));
        scene01.getChildren().removeAll();
        scene01.getChildren().setAll(scene02);
    }

    @FXML
    void exitGame(ActionEvent event) {
        System.out.println("Bye!");
        System.exit(0);
    }

  //  @FXML
   // void initialize() {
      //  txtName.setText(Data.text);
    //}
}