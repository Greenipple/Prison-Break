package org.academiadecodigo.felinux.GameObject.Item;

import org.academiadecodigo.felinux.Position.Map;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Key extends Item {

    public Key(MapPosition position, Map map) {
        super(position, GameObjectType.KEY, map);
    }

    public void store() {
        if (this.isHold()) {
            this.hide();
        }
    }
}
