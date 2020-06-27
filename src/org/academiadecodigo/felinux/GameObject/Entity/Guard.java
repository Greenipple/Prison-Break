package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.Position.CollisionDetector;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Guard extends Entity {

    public Guard(MapPosition position) {
        super(position, GameObjectType.GUARD);
    }
}