package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.Position.*;
import org.academiadecodigo.felinux.Support.*;

public abstract class Entity extends GameObject implements Movable {

    public Entity(MapPosition position, GameObjectType gameObjectType) {
        super(position, gameObjectType);
    }

}
