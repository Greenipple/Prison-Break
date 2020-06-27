package org.academiadecodigo.felinux.GameObject.DecorWall;

import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Wall extends GameObject {
    public Wall(MapPosition position) {
        super(position, GameObjectType.WALL);
    }
}
