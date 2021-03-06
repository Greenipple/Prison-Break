package org.academiadecodigo.felinux.GameObject.Item;

import org.academiadecodigo.felinux.GameObject.Entity.Player;
import org.academiadecodigo.felinux.Position.*;
import org.academiadecodigo.felinux.Support.DirectionType;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Barrel extends Item implements Movable {

    public Barrel(MapPosition position, Player player) {
        super(position, GameObjectType.BARREL,player);
    }

    @Override
    public void move() {
        if(this.isHold()) {
            getPlayer().gotBarrel();
            this.getPosition().setFacing(DirectionType.LEFT);
            return;
        }
        this.getPosition().setFacing(DirectionType.DOWN);
    }

}
