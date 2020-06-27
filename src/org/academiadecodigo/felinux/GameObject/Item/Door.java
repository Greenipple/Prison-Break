package org.academiadecodigo.felinux.GameObject.Item;

import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Door extends Item{

    public Door(MapPosition position) {
        super(position, GameObjectType.DOOR);
    }
}