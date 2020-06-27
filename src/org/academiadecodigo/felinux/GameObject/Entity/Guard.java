package org.academiadecodigo.felinux.PrisonBreakGame.GameObject.Entity;

import org.academiadecodigo.felinux.PrisonBreakGame.Position.CollisionDetector;
import org.academiadecodigo.felinux.PrisonBreakGame.Position.MapPosition;
import org.academiadecodigo.felinux.PrisonBreakGame.Support.GameObjectType;

public class Guard extends Entity {

    public Guard(MapPosition position) {
        super(position, GameObjectType.GUARD);
    }
}