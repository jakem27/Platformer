package com.example.platformer.model;

import javafx.scene.shape.Line;
import javafx.scene.paint.Color;

public class Platform extends GameObject {

    private Line platform;

    public Platform(double x, double y, double width) {
        super(new Line(0, 500, 350, 500), x, y, width, 8);
        this.platform = (Line) view;
        platform.setStroke(Color.LIGHTBLUE);
        platform.setStrokeWidth(2);
    }

    @Override
    protected void updateView() {
        // unnecessary
    }

    public void update(double elapsedTime) {
        // platforms don't move (yet)
    }
}
