package org.academiadecodigo.felinux.GameObject.Item;

import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Door extends Item {

    private boolean shut;

    public Door(MapPosition position) {
        super(position, GameObjectType.DOOR);
        this.shut = false;
    }

    public void shutDoor() {
        this.shut = true;
    }
    
    public void openDoor() {
        this.shut = false;
    }
}