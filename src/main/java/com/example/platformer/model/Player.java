package com.example.platformer.model;

import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class Player extends GameObject{

    private Text player;
    private double velocityY = 0;
    private String direction = "";
    private boolean onGround = false;
    private boolean jump = false;

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
        if(!onGround) {
            velocityY += 900 * elapsedTime;
            y = Math.min(900, y + velocityY * elapsedTime);
        } else if(jump) {
            velocityY = -300;
            onGround = false;
            jump = false;
        }

        if(direction.equals("right")) {
            x += 300 * elapsedTime;
        } else if(direction.equals("left")) {
            x -= 300 * elapsedTime;
        }

        updateView();
    }

    public void setOnGround(double y) {
        onGround = true;
        velocityY = 0;
        this.y = y;
    }

    public void moveLeft() {
        direction = "left";
    }

    public void moveRight() {
        direction = "right";
    }

    public void stop() {
        direction = "";
    }

    public void jump() {
        if(onGround) {
            jump = true;
        }
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }
}
