package org.academiadecodigo.felinux.GameObject.Item;

import org.academiadecodigo.felinux.Position.Map;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Door extends Item {

    private boolean shut;

    public Door(MapPosition position, Map map) {
        super(position, GameObjectType.DOOR, map);
        this.shut = false;
    }

    public void shutDoor() {
        this.shut = true;
    }

    public void openDoor() {
        this.shut = false;
    }
}