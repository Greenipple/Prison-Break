package org.academiadecodigo.felinux.GameObject;

import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.*;

public abstract class GameObject {

    private MapPosition position;
    private GameObjectType gameObjectType;

    public GameObject(MapPosition position, GameObjectType gameObjectType) {
        this.position = position;
        this.gameObjectType = gameObjectType;
        this.position.setColor(gameObjectType.getColor());
    }

    public MapPosition getPosition() {
        return this.position;
    }

    public void setPosition(MapPosition position) {
        this.getPosition().setPosition(position.getCol(),position.getRow());
    }
}