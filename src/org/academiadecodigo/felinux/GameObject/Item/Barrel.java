package org.academiadecodigo.felinux.GameObject.Item;

import org.academiadecodigo.felinux.Position.CollisionDetector;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Position.Movable;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Barrel extends Item implements Movable {

    public Barrel(MapPosition position) {
        super(position, GameObjectType.BARREL);
    }

    @Override
    public void setCollisionDetector(CollisionDetector collisionDetector) {

    }

    @Override
    public void move() {

    }

    public void move(MapPosition position) { //passing player position as argument, barrel will move alongside
        this.getRectangle().translate(position.getCol()-this.getPosition().getCol(),position.getRow()-this.getPosition().getRow());
        this.setPosition(position);
    }


}
