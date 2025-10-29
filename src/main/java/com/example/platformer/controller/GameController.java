package com.example.platformer.controller;

import com.example.platformer.model.GameWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class GameController {
    private Stage stage;
    private Scene scene;
    private GameWorld gameWorld;

    @FXML
    protected void onStartButtonClick(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Group root = new Group();
        gameWorld = new GameWorld(root);

        Scene gameScene = new Scene(root, 350, 600);
        scene = gameScene;
        stage.setScene(gameScene);
        stage.show();
    }

    @FXML
    protected void onOptionsButtonClick() {

    }

    @FXML
    protected void onControlsButtonClick() {

    }


}