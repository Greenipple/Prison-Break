package org.academiadecodigo.felinux.PrisonBreakGame.GameObject.Item;

import org.academiadecodigo.felinux.PrisonBreakGame.Position.MapPosition;
import org.academiadecodigo.felinux.PrisonBreakGame.Support.GameObjectType;

public class Key extends Item {

    public Key(MapPosition position) {
        super(position, GameObjectType.KEY); //definir posição inicial
    }
}
