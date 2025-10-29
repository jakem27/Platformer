package com.example.platformer.model;

import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class Player extends GameObject{

    private Text player;
    private double velocityY = 0;

    private boolean onGround = false;

    public Player(double x, double y) {
        super(new Text("a"), x, y, 0, 0);
        this.player = (Text) view;
        player.setFont(new Font("Consolas", 36));
        player.setFill(Color.BLACK);
    }

    @Override
    protected void updateView() {
        view.setLayoutX(x);
        view.setLayoutY(y);
    }

    public void update(double elapsedTime) {
        // x = x + velocityX * elapsedTime;
        if(!onGround) {
            velocityY += 300 * elapsedTime;
            y += velocityY * elapsedTime;
        }

        updateView();
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }
}
