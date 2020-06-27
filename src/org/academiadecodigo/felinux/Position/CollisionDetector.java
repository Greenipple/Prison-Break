package org.academiadecodigo.felinux.Position;

import org.academiadecodigo.felinux.GameObject.Entity.*;
import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.GameObject.Item.*;

public class CollisionDetector {
    private static Player player;
    private static GameObject[] objects; //guards, dogs, key and barrel. Walls & fences will be apart

    public CollisionDetector(Player player, GameObject[] objects) {
        this.player = player;
        this.objects = objects;
    }

    public static void verify() {
        for (GameObject object : objects) {
            if (player.getPosition() == object.getPosition()) {
                if (object instanceof Guard || object instanceof Dog) {
                    player.gotDetected(); //player is detected if he crashes into a guard or dog
                }

                if (object instanceof Barrel) {
                    Barrel barrel = (Barrel) object;
                    barrel.beenHold();
                }

                if (object instanceof Key) {
                    Key key = (Key) object;
                    key.beenHold();
                }
            }
        }
    }
}