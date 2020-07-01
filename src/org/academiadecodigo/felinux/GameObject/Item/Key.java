package org.academiadecodigo.felinux.GameObject.Item;

import org.academiadecodigo.felinux.GameObject.Entity.Player;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Key extends Item {

    public Key(MapPosition position, Player player) {
        super(position, GameObjectType.KEY,player);
    }

    public void check() {

        this.beenHold();

        if (this.isHold()) {
            this.getPosition().hide();
            getPlayer().gotKey();
        }
    }

    @Override
    public void beenHold() {
        super.beenHold();
       if (this.isHold()==true) {
           this.getPlayer().gotKey();
       }
    }
}
