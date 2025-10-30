package com.example.platformer.util;

import com.example.platformer.model.GameObject;
import com.example.platformer.model.Platform;
import javafx.scene.Group;

import java.util.List;
import java.util.Random;

public class PlatformGenerator {
    private final Random rand = new Random();
    private final double minWidth = 50;
    private final double maxWidth = 150;

    private double nextPlatformY = 450;

    public void generateUntil(double targetY, Group root, List<GameObject> objects) {
        while(nextPlatformY > targetY) {
            Platform p = createRandomPlatform(nextPlatformY);
            objects.add(p);
            root.getChildren().add(p.getNode());

            nextPlatformY -= 50;
        }
    }

    private Platform createRandomPlatform(double y) {
        double width = minWidth + rand.nextDouble() * (maxWidth - minWidth);
        double x = 10 + rand.nextDouble() * (Math.max(0, 330 - width));

        return new Platform(x, y, width);
    }
}
