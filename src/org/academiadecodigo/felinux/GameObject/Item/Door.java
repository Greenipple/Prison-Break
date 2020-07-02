package org.academiadecodigo.felinux.GameObject.Item;

import org.academiadecodigo.felinux.GameObject.DecorWall.Sound;
import org.academiadecodigo.felinux.GameObject.Entity.Player;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Door extends Item {

    private boolean shut;
    private Sound unlockDoor;

    public Door(MapPosition position, Player player) {
        super(position, GameObjectType.DOOR, player);
        this.shut = false;
        unlockDoor=new Sound("/resources/Sounds/door_lock.wav");
    }

    public boolean isShut(){
        return this.shut;
    }

    public void shutDoor() {
        this.shut = true;
    }

    public void check() {

        if (this.getPlayer().hasKey() &&
                this.getPlayer().getPosition().getRow() == this.getPosition().getRow() - 1 &&
                this.getPlayer().getPosition().getCol() == this.getPosition().getCol()/* &&
                this.getPlayer().getAction()*/) {
            this.shut = false;
            unlockDoor.play(true);
        }
    }

    @Override
    public boolean isHold() {
        return false;
    }
}