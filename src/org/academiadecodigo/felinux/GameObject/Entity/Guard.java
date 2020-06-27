package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.Position.CollisionDetector;
import org.academiadecodigo.felinux.Position.Map;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Position.Route;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Guard extends Entity {

    private Route route1;

    public Guard(MapPosition position, Map map) {
        super(position, GameObjectType.GUARD, map
        );
    }

}