package com.example.platformer.util;
import com.example.platformer.model.*;

import java.util.*;

public class PhysicsEngine {

    public void update(List<GameObject> objects, Player player, double elapsedTime) {
        for(GameObject obj : objects) {
            if(obj == player) {
                // apply physics
            } else if(obj instanceof Platform) {
                // detect platform collision
            } else if(obj instanceof Obstacle) {
                // detect obstacle collision
            }
        }
    }

    public void applyPhysics(Player player, double elapsedTime) {
        player.setVelocityY(player.getVelocityY() + 300 * elapsedTime);
        player.update(elapsedTime);
    }

    public void detectCollision(Platform platform, Player player) {

    }

    public void detectCollision(Obstacle obstacle, Player player) {

    }
}
