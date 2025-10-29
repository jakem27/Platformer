package com.example.platformer.model;

import com.example.platformer.util.InputHandler;
import com.example.platformer.util.PhysicsEngine;
import com.example.platformer.util.SpriteLoader;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;

import java.util.*;

public class GameWorld {
    private Group root;

    //private InputHandler inputHandler;
    //private PhysicsEngine physicsEngine;
    //private SpriteLoader spriteLoader;


    private List<GameObject> objects;
    private Player player;

    private AnimationTimer gameLoop;

    public GameWorld(Group root) {
        this.root = root;

        //inputHandler = ih;
        //physicsEngine = pe;
        //spriteLoader = sl;
        objects = new ArrayList<>();

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
        for(GameObject obj : objects) {
            if(obj == player) {
                update(elapsedTime);
            } else if(obj instanceof Platform) {
                // detect platform collision
                if(obj.getBounds().intersects(player.getBounds())) {
                    if(player.getVelocityY() > 0) {

                    }
                }
            } else if(obj instanceof Obstacle) {
                // detect obstacle collision
            }
        }
    }



}
