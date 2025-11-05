package com.example.platformer.util;

import com.example.platformer.model.GameObject;
import com.example.platformer.model.Platform;
import javafx.scene.Group;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class PlatformGenerator {
    private final Random rand = new Random();
    private final double minWidth = 50;
    private final double maxWidth = 150;

    private double SCREEN_WIDTH;
    private double SCREEN_HEIGHT;
    private double nextPlatformY;

    public PlatformGenerator(double width, double height) {
        SCREEN_WIDTH = width;
        SCREEN_HEIGHT = height;

        nextPlatformY = SCREEN_HEIGHT * 0.85 - 50;
    }

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
        double x = 10 + rand.nextDouble() * (350 - width);

        return new Platform(x, y, width);
    }

    public void cleanupPlatforms(double thresholdY, Group root, List<GameObject> objects) {
        Iterator<GameObject> it = objects.iterator();
        while(it.hasNext()) {
            GameObject obj = it.next();
            if(obj instanceof Platform p) {
                if(p.getY() > thresholdY) {
                    root.getChildren().remove(p.getNode());
                    it.remove();
                }
            }
        }
    }
}
