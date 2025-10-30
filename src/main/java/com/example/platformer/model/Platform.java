package com.example.platformer.model;

import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Platform extends GameObject {

    private Rectangle platform;

    public Platform(double x, double y, double width) {
        super(new Rectangle(x, y, width, 4), x, y, width, 4);
        this.platform = (Rectangle) view;
        platform.setFill(Color.LIGHTBLUE);
    }

    @Override
    protected void updateView() {
        // unnecessary
    }

    public void update(double elapsedTime) {
        // platforms don't move (yet)
    }
}
