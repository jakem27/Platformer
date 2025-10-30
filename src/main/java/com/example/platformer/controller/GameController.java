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
        scene = new Scene(root, 350, 600);

        gameWorld = new GameWorld(root, scene);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onOptionsButtonClick() {

    }

    @FXML
    protected void onControlsButtonClick() {

    }


}