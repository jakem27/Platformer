package com.example.platformer.model;

import javafx.scene.shape.Line;
import javafx.scene.paint.Color;

public class Platform extends GameObject {

    private Line platform;

    public Platform(double x, double y, double width) {
        super(new Line(x, y, width, 5), x, y, width, 5);
        this.platform = (Line) view;
        platform.setFill(Color.LIGHTBLUE);
    }

    public void update(double elapsedTime) {
        // platforms don't move
    }
}
