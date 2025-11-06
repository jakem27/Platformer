package com.example.platformer.util;

import com.example.platformer.model.GameObject;
import com.example.platformer.model.Missile;
import com.example.platformer.model.Anvil;
import javafx.scene.Group;

import java.util.List;
import java.util.Random;

public class ObstacleGenerator {
    private Random rand = new Random();
    private final double SCREEN_WIDTH;
    private final double SCREEN_HEIGHT;

    public ObstacleGenerator(double width, double height) {
        SCREEN_WIDTH = width;
        SCREEN_HEIGHT = height;
    }

    public void load(double y, Group root, List<GameObject> objects) {
        double r = rand.nextDouble();
        if(r > 0.5) {
            double x = 10 + (SCREEN_WIDTH * rand.nextDouble() - 20);
            Anvil anvil = new Anvil(x, y);
            root.getChildren().add(anvil.getNode());
            objects.add(anvil);
        } else if(r > 0) {
            y += SCREEN_HEIGHT * 0.9 * rand.nextDouble();
            Missile missile;
            if(rand.nextDouble() > 0.5) {
                missile = new Missile(-10, y, 1);
            } else {
                missile = new Missile(SCREEN_WIDTH + 10, y, -1);
            }
            root.getChildren().add(missile.getNode());
            objects.add(missile);
        } else {
            //double y = SCREEN_HEIGHT * rand.nextDouble();
            // create ) obstacle at (0, y) or (SCREEN_WIDTH, y)
        }
    }
}
