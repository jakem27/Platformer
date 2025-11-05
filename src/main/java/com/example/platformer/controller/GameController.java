package com.example.platformer.controller;

import com.example.platformer.App;
import com.example.platformer.model.GameWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
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

        // build game scene root
        Group root = new Group();
        Group gameGroup = new Group();
        root.getChildren().add(gameGroup);

        // create the game world
        Scene gameScene = new Scene(root, 350, 600);
        gameWorld = new GameWorld(gameGroup, gameScene);

        // load the hud FXML and bind it to the game world
        FXMLLoader hudLoader = new FXMLLoader(App.class.getResource("fxml/game-hud.fxml"));
        Parent hud = hudLoader.load();
        HudController hudController = hudLoader.getController();
        hudController.bindToGameWorld(gameWorld);
        root.getChildren().add(hud);

        // show the scene on stage
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