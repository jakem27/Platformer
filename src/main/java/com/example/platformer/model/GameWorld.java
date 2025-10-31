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
    private Group root;

    private InputHandler inputHandler;
    private PlatformGenerator platformGenerator;
    //private PhysicsEngine physicsEngine;
    //private SpriteLoader spriteLoader;


    private List<GameObject> objects;
    private Player player;

    private AnimationTimer gameLoop;

    public GameWorld(Group root, Scene scene) {
        this.root = root;

        objects = new ArrayList<>();

        inputHandler = new InputHandler();
        inputHandler.attachToScene(scene);
        platformGenerator = new PlatformGenerator();

        init();
        startLoop();
    }

    private void init() {

        player = new Player(165, 480);
        Platform platform = new Platform(0, 500, 350);

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
