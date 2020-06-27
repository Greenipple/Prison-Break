package org.academiadecodigo.felinux.GameObject.DecorWall;

import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.Position.Map;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Fence extends GameObject {

    public Fence(MapPosition position, Map map) {
        super(position, GameObjectType.FENCE, map);
    }
}
