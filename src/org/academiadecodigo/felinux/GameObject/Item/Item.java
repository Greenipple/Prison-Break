package org.academiadecodigo.felinux.GameObject.Item;

import org.academiadecodigo.felinux.GameObject.Entity.Player;
import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.DirectionType;
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
        if (getPlayer().getPosition().getRow() == this.getPosition().getRow() &&
                getPlayer().getPosition().getCol() == this.getPosition().getCol()) {
            this.hold = true;
            return;
        }
    }

    public void drop() {
        this.hold = false;
        this.getPosition().setFacing(DirectionType.LEFT);
        this.getPosition().show();

    }

    public Player getPlayer() {
        return this.player;
    }
}