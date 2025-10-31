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
    private Platform platform = null;

    public Player(double x, double y) {
        super(new Text("a"), x, y, 0, 0);
        this.player = (Text) view;
        player.setFont(new Font("Consolas", 36));
        player.setFill(Color.BLACK);

        setWidth(player.getLayoutBounds().getWidth());
        //setHeight(player.getLayoutBounds().getHeight());
    }


    protected void updateView() {
        view.setLayoutX(x);
        view.setLayoutY(y);
    }

    public void update(double elapsedTime) {
        // gravity and jump
        if(!onGround) {
            velocityY = Math.min(300, velocityY + 800 * elapsedTime);
            y += velocityY * elapsedTime;
        } else if(jump) {
            velocityY = -300;
            onGround = false;
            jump = false;
            platform = null;
        }

        // horizontal movement
        if(direction.equals("right")) {
            x =  Math.min(350 - width, x + 300 * elapsedTime);
        } else if(direction.equals("left")) {
            x = Math.max(0, x - 300 * elapsedTime);
        }

        // falling off platforms
        if(onGround && platform != null) {
            double platLeft = platform.getX();
            double platRight = platform.getX() + platform.getWidth();

            if(this.x + this.width <= platLeft + 0.5 || this.x >= platRight - 0.5) {
                onGround = false;
                platform = null;
            }
        }


        updateView();
    }

    public void setOnGround(double y, Platform p) {
        onGround = true;
        velocityY = 0;
        this.y = y;
        platform = p;
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
