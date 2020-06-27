package org.academiadecodigo.felinux.GameObject.Item;

import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Item extends GameObject {

    private boolean hold;

    public Item(MapPosition position, GameObjectType gameObjectType) {
        super(position, gameObjectType);
        this.hold = false;
    }

    public boolean isHold() {
        return this.hold;
    }

    public void beenHold() {
        this.hold = true;
    }
}