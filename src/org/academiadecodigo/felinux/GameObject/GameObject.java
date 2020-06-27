package org.academiadecodigo.felinux.GameObject;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.felinux.Position.Map;

import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.*;

import java.awt.*;


public abstract class GameObject {

    private MapPosition position;
    private Map map;
    private GameObjectType gameObjectType;
    private Rectangle rectangle;


    public GameObject(MapPosition position, GameObjectType gameObjectType) {
        this.position = position;
        this.gameObjectType = gameObjectType;
        this.rectangle = new Rectangle(position.getCol() * Map.CELL_SIZE + Map.PADDING, position.getRow() * Map.CELL_SIZE + Map.PADDING, Map.CELL_SIZE, Map.CELL_SIZE);
        //position.setColor();
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public MapPosition getPosition() {
        return this.position;
    }

    public void setPosition(MapPosition position) {
        this.position = position;
    }

    public Rectangle getRectangle(){
        return this.rectangle;
    }
}
