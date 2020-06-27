package org.academiadecodigo.felinux.PrisonBreakGame.GameObject.DecorWall;

import org.academiadecodigo.felinux.PrisonBreakGame.GameObject.GameObject;
import org.academiadecodigo.felinux.PrisonBreakGame.Position.MapPosition;
import org.academiadecodigo.felinux.PrisonBreakGame.Support.GameObjectType;

public class Fence extends GameObject {

    public Fence(MapPosition position) {
        super(position, GameObjectType.FENCE);
    }
}
