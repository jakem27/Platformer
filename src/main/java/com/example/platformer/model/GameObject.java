package com.example.platformer.model;

import javafx.scene.Node;

public abstract class GameObject {
    protected Node view;
    protected double x;
    protected double y;
    protected double width;
    protected double height;

    public GameObject(Node view, double x, double y, double width, double height) {
        this.view = view;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        updateView();
    }

    public abstract void update(double deltaTime);

    public Node getNode() {
        return view;
    }

    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
        updateView();
    }

    protected void updateView() {
        view.setLayoutX(x);
        view.setLayoutY(y);
    }
}
