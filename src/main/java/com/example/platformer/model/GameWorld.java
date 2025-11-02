package com.example.platformer.model;

import com.example.platformer.util.InputHandler;
import com.example.platformer.util.PhysicsEngine;
import com.example.platformer.util.PlatformGenerator;
import com.example.platformer.util.SpriteLoader;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;

import java.util.*;

public class GameWorld {
    private final double SCREEN_WIDTH = 350;
    private final double SCREEN_HEIGHT = 600;
    private Group root;

    private InputHandler inputHandler;
    private PlatformGenerator platformGenerator;
    //private PhysicsEngine physicsEngine;
    //private SpriteLoader spriteLoader;


    private List<GameObject> objects;
    private Player player;
    private double cameraY;
    private double highestYReached;
    private AnimationTimer gameLoop;

    public GameWorld(Group root, Scene scene) {
        this.root = root;

        objects = new ArrayList<>();

        inputHandler = new InputHandler();
        inputHandler.attachToScene(scene);
        platformGenerator = new PlatformGenerator(SCREEN_WIDTH, SCREEN_HEIGHT);

        cameraY = 0;

        init();
        startLoop();
    }

    private void init() {

        player = new Player(SCREEN_WIDTH / 2, SCREEN_HEIGHT * 0.8);
        highestYReached = player.getY();
        Platform platform = new Platform(0, SCREEN_HEIGHT * 0.85, SCREEN_WIDTH);

        objects.add(player);
        objects.add(platform);

        root.getChildren().add(player.getNode());
        root.getChildren().add(platform.getNode());

        platformGenerator.generateUntil(0, root, objects);
    }

    private void startLoop() {
        gameLoop = new AnimationTimer() {
            long previousTime = -1;
            @Override
            public void handle(long currentTime) {
                if(previousTime != -1) {
                    double elapsedTime = (currentTime - previousTime) / 1000000000.0;
                    update(elapsedTime);
                }

                previousTime = currentTime;
            }

            @Override
            public void start() {
                previousTime = System.nanoTime();
                super.start();
            }

            @Override
            public void stop() {
                previousTime = -1;
                super.stop();
            }
        };

        gameLoop.start();
    }

    private void update(double elapsedTime) {
        // generate platforms
        if(player.getY() < highestYReached) {
            highestYReached = player.getY();
            double targetY = highestYReached - SCREEN_HEIGHT;
            platformGenerator.generateUntil(targetY, root, objects);
        }

        // Remove old platforms
        double cleanupThreshold = player.getY() + SCREEN_HEIGHT * 1.5;
        platformGenerator.cleanupPlatforms(cleanupThreshold, root, objects);

        // move camera
        cameraY = Math.min(cameraY, player.getY() - SCREEN_HEIGHT * 0.4);
        root.setLayoutY(-cameraY);

        // handle input
        if(inputHandler.isRightPressed()) {
            player.moveRight();
        } else if(inputHandler.isLeftPressed()) {
            player.moveLeft();
        } else {
            player.stop();
        }

        if(inputHandler.isJumpPressed()) {
            player.jump();
        }

        // update game objects
        for(GameObject obj : objects) {
            if(obj == player) {
                player.update(elapsedTime);
            } else if(obj instanceof Platform) {
                // detect platform collision
                if(obj.getBounds().intersects(player.getBounds())) {
                    if(player.getVelocityY() > 0) {
                        player.setOnGround(obj.getBounds().getMinY(), (Platform) obj);
                    }
                }
            } else if(obj instanceof Obstacle) {
                // move obstacle and detect collision with player
            }
        }
    }




}
