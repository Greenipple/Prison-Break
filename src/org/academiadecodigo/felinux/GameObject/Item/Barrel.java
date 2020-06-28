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
        this.checkHolding();
        if(this.isHold()) {
            this.getPosition().getRectangle().translate(getPlayer().getPosition().getCol() - this.getPosition().getCol(), getPlayer().getPosition().getRow() - this.getPosition().getRow());
            this.setPosition(getPlayer().getPosition());
        }
    }
}
