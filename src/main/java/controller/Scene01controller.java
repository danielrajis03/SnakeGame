package controller;



import GamePlay.Play;
import example.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

    public class Scene01controller {

    @FXML
    private AnchorPane scene01;



        /*
            @FXML
            private TextField txtName;
        */
    @FXML
    void moveToNextScene(ActionEvent event) throws IOException {

        scene01.getChildren().removeAll();

    }

    @FXML
    void startGame(ActionEvent event) {
        System.out.println("Game Started");
        new Play().loadFrame();
        MusicPlayer.getMusicPlay("src/main/resources/frogger.mp3");
        scene01.getChildren().removeAll();








    }

    @FXML
    void exitGame(ActionEvent event) {
        System.out.println("Game Over");
        System.exit(0);

    }
/*
        @FXML
        void initialize() {
            txtName.setText(Data.text);
        }*/
}