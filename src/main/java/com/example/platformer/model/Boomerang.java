package com.example.platformer.model;

public class Boomerang extends Obstacle {

    private final double Y_VELOCITY;
    private double xVelocity;
    private int direction;

    public Boomerang(double x, double y, int direction) {
        super(x, y, ")");
        Y_VELOCITY = 100;
        this.direction = direction;
        if(direction > 0) {
            xVelocity = 400;
        } else {
            xVelocity = -400;
        }
    }

    public void update(double elapsedTime) {
        y += Y_VELOCITY * elapsedTime;
        if(direction > 0) {
            xVelocity = Math.max(-400, xVelocity - 400 * elapsedTime);
            x += xVelocity * elapsedTime;
        } else {
            xVelocity = Math.min(400, xVelocity + 400 * elapsedTime);
            x += xVelocity * elapsedTime;
        }

        obstacle.setRotate(obstacle.getRotate() + (720 * elapsedTime));

        updateView();
    }

}
