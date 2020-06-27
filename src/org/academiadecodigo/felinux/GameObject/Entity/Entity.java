package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.Position.*;
import org.academiadecodigo.felinux.Support.*;

public abstract class Entity extends GameObject implements Movable {

    public CollisionDetector collisionDetector;
    public DirectionType directionType;

    public Entity(MapPosition position, GameObjectType gameObjectType, Map map) {
        super(position, gameObjectType, map);
    }

    public void move() {

    }

    @Override
    public void setCollisionDetector(CollisionDetector collisionDetector) {

    }

}
