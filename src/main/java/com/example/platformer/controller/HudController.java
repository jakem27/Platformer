package com.example.platformer.controller;

import com.example.platformer.model.GameWorld;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HudController {
    @FXML
    private Label score;

    public void bindToGameWorld(GameWorld gameWorld) {
        score.textProperty().bind(gameWorld.scoreProperty().asString("Score: %d"));
    }
}
