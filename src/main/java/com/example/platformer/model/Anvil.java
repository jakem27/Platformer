package com.example.platformer.model;

public class Anvil extends Obstacle{

    private final double Y_VELOCITY;

    public Anvil(double x, double y) {
        super(x, y, "?");
        Y_VELOCITY = 350;
    }

    public void update(double elapsedTime) {
        y += Y_VELOCITY * elapsedTime;
        updateView();
    }
}
