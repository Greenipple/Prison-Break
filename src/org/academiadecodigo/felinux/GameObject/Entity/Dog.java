package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.*;

public class Dog extends Entity {
    public Dog(MapPosition position) {
        super(position, GameObjectType.DOG);
    }

    @Override
    public void move() {

        DirectionType direction = DirectionType.values()[(int) Math.floor(Math.random() * 4)];

        this.getPosition().moveInDirection(direction, 1);
    }
}