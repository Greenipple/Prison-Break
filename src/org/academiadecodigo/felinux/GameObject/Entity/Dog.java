package org.academiadecodigo.felinux.PrisonBreakGame.GameObject.Entity;

import org.academiadecodigo.felinux.PrisonBreakGame.Position.CollisionDetector;
import org.academiadecodigo.felinux.PrisonBreakGame.Position.MapPosition;
import org.academiadecodigo.felinux.PrisonBreakGame.Support.GameObjectType;

public class Dog extends Entity {

    public Dog(MapPosition position) {
        super(position, GameObjectType.DOG);
    }

    @Override
    public void setCollisionDetector(CollisionDetector collisionDetector) {

    }
}
