package org.academiadecodigo.felinux.PrisonBreakGame.GameObject.Entity;

import org.academiadecodigo.felinux.PrisonBreakGame.GameObject.GameObject;
import org.academiadecodigo.felinux.PrisonBreakGame.Position.*;
import org.academiadecodigo.felinux.PrisonBreakGame.Support.*;

public abstract class Entity extends GameObject implements Movable {

    public CollisionDetector collisionDetector;
    public DirectionType directionType;

    public Entity(MapPosition position, GameObjectType gameObjectType) {
        super(position, gameObjectType);
    }

    public void move() {
    }

    @Override
    public void setCollisionDetector(CollisionDetector collisionDetector) {

    }

}
