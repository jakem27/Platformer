package com.example.platformer.model;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
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

    public Node getNode() {
        return view;
    }

    public Bounds getBounds() { return new BoundingBox(x, y, width, height); }

    public void setX(double x) { this.x = x; }

    public double getX() { return x; }

    public void setY(double y) { this.y = y; }

    public double gety() { return y; }

    public abstract void update(double deltaTime);

    protected abstract void updateView();
}
