package com.example.platformer.model;

import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class Obstacle extends GameObject {

    private Text obstacle;

    public Obstacle(double x, double y) {
        super(new Text("?"), x, y, 0, 0);
        this.obstacle = (Text) view;
        obstacle.setFont(new Font("Consolas", 36));
        obstacle.setFill(Color.RED);
    }

    public void update(double elapsedTime) {
        //to be implemented
    }

}
