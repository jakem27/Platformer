package com.example.platformer.util;

import javafx.scene.Scene;
import java.util.HashSet;
import java.util.Set;

public class InputHandler {

    private final Set<String> activeKeys = new HashSet<>();

    public void attachToScene(Scene scene) {
        scene.setOnKeyPressed(event -> activeKeys.add(event.getCode().toString()));
        scene.setOnKeyReleased(event -> activeKeys.remove(event.getCode().toString()));
    }

    public boolean isLeftPressed() {
        return activeKeys.contains("A") || activeKeys.contains("LEFT");
    }

    public boolean isRightPressed() {
        return activeKeys.contains("D") || activeKeys.contains("RIGHT");
    }

    public boolean isJumpPressed() {
        return activeKeys.contains("SPACE") || activeKeys.contains("W") || activeKeys.contains("UP");
    }

    public boolean isDownPressed() {
        return activeKeys.contains("S") || activeKeys.contains("DOWN");
    }
}
