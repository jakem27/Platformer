package com.example.platformer.model;

import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public abstract class Obstacle extends GameObject {

    protected Text obstacle;

    public Obstacle(double x, double y, String s) {
        super(new Text(s), x, y, 0, 0);
        this.obstacle = (Text) view;
        obstacle.setFont(new Font("Consolas", 36));
        obstacle.setFill(Color.RED);
    }

    @Override
    protected void updateView() {
        view.setLayoutX(x);
        view.setLayoutY(y);
    }

}
