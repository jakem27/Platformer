package com.example.platformer.model;

public class Missile extends Obstacle {
    private final double X_VELOCITY;

    public Missile(double x, double y, int direction) {
        super(x, y, "!");
        if(direction > 0) {
            X_VELOCITY = 300;
            obstacle.setRotate(90);
        } else {
            X_VELOCITY = -300;
            obstacle.setRotate(270);
        }
    }

    public void update(double elapsedTime) {
        x += X_VELOCITY * elapsedTime;
        updateView();
    }
}
