package org.academiadecodigo.felinux.GameObject.Item;

import org.academiadecodigo.felinux.GameObject.DecorWall.Sound;
import org.academiadecodigo.felinux.GameObject.Entity.Player;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Key extends Item {

    private Sound keySound;

    public Key(MapPosition position, Player player) {
        super(position, GameObjectType.KEY,player);
        keySound = new Sound("/resources/Sounds/Keys.wav");
    }

    public void check() {

        this.beenHold();

        if (this.isHold() && !getPlayer().hasKey()) {
            this.getPosition().hide();
            getPlayer().gotKey();
            keySound.play(true);
        }
    }

    @Override
    public void beenHold() {
        super.beenHold();
    }
}
