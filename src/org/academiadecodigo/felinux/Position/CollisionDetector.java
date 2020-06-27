package org.academiadecodigo.felinux.PrisonBreakGame.Position;

import org.academiadecodigo.felinux.PrisonBreakGame.GameObject.Entity.*;
import org.academiadecodigo.felinux.PrisonBreakGame.GameObject.Item.*;

public class CollisionDetector {
    private Player player;
    private Entity[] entities;
    private Key key;
    private Barrel barrel;

    public CollisionDetector(Player player, Entity[] entities, Key key, Barrel barrel) {
        this.player = player;
        this.entities = entities;
        this.key = key;
        this.barrel = barrel;
    }
}