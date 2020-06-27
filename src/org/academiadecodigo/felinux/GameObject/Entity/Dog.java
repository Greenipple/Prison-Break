package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.Position.CollisionDetector;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Dog extends Entity {

    public Dog(MapPosition position) {
        super(position, GameObjectType.DOG);
    }

    @Override
    public void setCollisionDetector(CollisionDetector collisionDetector) {

    }
}
