package com.example.platformer.model;

import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Platform extends GameObject {

    private Rectangle platform;
    private boolean reached;

    public Platform(double x, double y, double width) {
        super(new Rectangle(x, y, width, 4), x, y, width, 4);
        this.platform = (Rectangle) view;
        platform.setFill(Color.LIGHTBLUE);
        reached = false;
    }

    @Override
    protected void updateView() {
        // unnecessary
    }

    public void update(double elapsedTime) {
        // platforms don't move (yet)
        //updateView();
    }

    public void reached() {
        reached = true;
    }

    public boolean hasReached() {
        return reached;
    }
}
