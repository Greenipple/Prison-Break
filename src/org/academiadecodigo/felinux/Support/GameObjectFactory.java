package org.academiadecodigo.felinux.Support;

import org.academiadecodigo.felinux.Game;
import org.academiadecodigo.felinux.GameObject.*;
import org.academiadecodigo.felinux.GameObject.DecorWall.*;
import org.academiadecodigo.felinux.GameObject.Entity.*;
import org.academiadecodigo.felinux.GameObject.Item.*;
import org.academiadecodigo.felinux.Position.*;

public class GameObjectFactory {


    public static GameObject create(GameObjectType type, MapPosition position, Map map) {
        switch (type) {
            case FENCE:
                return new Fence(position, map);
            case WALL:
                return new Wall(position, map);
            case BARREL:
                return new Barrel(position, map);
            case KEY:
                return new Key(position, map);
            case DOOR:
                return new Door(position, map);
            case GUARD:
                return new Guard(position, map);
            case DOG:
                return new Dog(position, map);
            default:
                return new Player(position, map);
        }
    }
}