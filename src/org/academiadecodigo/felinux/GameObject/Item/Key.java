package org.academiadecodigo.felinux.GameObject.Item;

import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Key extends Item {

    public Key(MapPosition position) {
        super(position, GameObjectType.KEY); //definir posição inicial
    }
}
