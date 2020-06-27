package org.academiadecodigo.felinux.PrisonBreakGame.GameObject.Item;

import org.academiadecodigo.felinux.PrisonBreakGame.Position.CollisionDetector;
import org.academiadecodigo.felinux.PrisonBreakGame.Position.MapPosition;
import org.academiadecodigo.felinux.PrisonBreakGame.Position.Movable;
import org.academiadecodigo.felinux.PrisonBreakGame.Support.GameObjectType;

public class Barrel extends Item implements Movable {

    public Barrel(MapPosition position) {
        super(position, GameObjectType.BARREL);
    }

    @Override
    public void setCollisionDetector(CollisionDetector collisionDetector) {

    }
}
