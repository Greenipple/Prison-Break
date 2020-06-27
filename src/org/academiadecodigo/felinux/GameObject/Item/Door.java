package org.academiadecodigo.felinux.PrisonBreakGame.GameObject.Item;

import org.academiadecodigo.felinux.PrisonBreakGame.Position.MapPosition;
import org.academiadecodigo.felinux.PrisonBreakGame.Support.GameObjectType;

public class Door extends Item{

    public Door(MapPosition position) {
        super(position, GameObjectType.DOOR);
    }
}