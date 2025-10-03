package com.example.platformer.model;

import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class Player extends GameObject{

    private Text player;
    private double velocityY = 0;

    public Player(double x, double y) {
        super(new Text("a"), x, y, 0, 0);
        this.player = (Text) view;
        player.setFont(new Font("Consolas", 36));
        player.setFill(Color.BLACK);
    }

    public void update(double elapsedTime) {
        //to be implemented
    }

}
