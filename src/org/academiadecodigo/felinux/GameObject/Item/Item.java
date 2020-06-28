package org.academiadecodigo.felinux.GameObject.Item;

import org.academiadecodigo.felinux.GameObject.Entity.Player;
import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Item extends GameObject {

    private Player player;
    private boolean hold;

    public Item(MapPosition position, GameObjectType gameObjectType, Player player) {
        super(position, gameObjectType);
        this.hold = false;
        this.player = player;
    }

    public boolean isHold() {
        return this.hold;
    }

    public void beenHold() {
        this.hold = true;
    }

    public void checkHolding() {
        if (getPlayer().getAction() && getPlayer().getPosition().getRow() == this.getPosition().getRow() && getPlayer().getPosition().getCol() == getPlayer().getPosition().getCol()) {
            this.beenHold();
        }
    }

    public Player getPlayer() {
        return this.player;
    }
}