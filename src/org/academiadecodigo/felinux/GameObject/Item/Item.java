package org.academiadecodigo.felinux.PrisonBreakGame.GameObject.Item;

import org.academiadecodigo.felinux.PrisonBreakGame.GameObject.GameObject;
import org.academiadecodigo.felinux.PrisonBreakGame.Position.MapPosition;
import org.academiadecodigo.felinux.PrisonBreakGame.Support.GameObjectType;

public class Item extends GameObject {

    private boolean holded;

    public Item(MapPosition position, GameObjectType gameObjectType) {
        super(position, gameObjectType);
        this.holded = false;
    }
}