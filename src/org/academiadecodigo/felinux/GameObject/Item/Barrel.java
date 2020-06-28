package org.academiadecodigo.felinux.GameObject.Item;

import org.academiadecodigo.felinux.GameObject.Entity.Player;
import org.academiadecodigo.felinux.Position.*;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Barrel extends Item implements Movable {

    public Barrel(MapPosition position, Player player) {
        super(position, GameObjectType.BARREL,player);
    }

    @Override
    public void move() {

        this.beenHold();

        if(this.isHold()) {
            this.setPosition(getPlayer().getPosition());
            this.getPlayer().getPosition().hide();
            return;
        }

        //this.setPosition(this.getPosition());
        //this.getPlayer().getPosition().show();
    }

}
