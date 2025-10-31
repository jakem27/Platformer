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
        updateView(0);
    }

    public Node getNode() {
        return view;
    }

    public Bounds getBounds() { return new BoundingBox(x, y, width, height); }

    public void setX(double x) { this.x = x; }

    public double getX() { return x; }

    public void setY(double y) { this.y = y; }

    public double getY() { return y; }
    public double getWidth() { return width; }
    public double getHeight() {return height; }

    protected void setWidth(double width) { this.width = width; }
    protected void setHeight(double height) { this.height = height; }

    public abstract void update(double deltaTime, double cameraY);

    protected abstract void updateView(double cameraY);
}
