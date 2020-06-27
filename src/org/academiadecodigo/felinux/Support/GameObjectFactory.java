package org.academiadecodigo.felinux.PrisonBreakGame.Support;

import org.academiadecodigo.felinux.PrisonBreakGame.Game;
import org.academiadecodigo.felinux.PrisonBreakGame.GameObject.*;
import org.academiadecodigo.felinux.PrisonBreakGame.GameObject.DecorWall.*;
import org.academiadecodigo.felinux.PrisonBreakGame.GameObject.Entity.*;
import org.academiadecodigo.felinux.PrisonBreakGame.GameObject.Item.*;
import org.academiadecodigo.felinux.PrisonBreakGame.Position.*;

public class GameObjectFactory {

    public static GameObject create(GameObjectType type, MapPosition position) {
        switch (type) {
            case FENCE:
                return new Fence(position);
            case WALL:
                return new Wall(position);
            case BARREL:
                return new Barrel(position);
            case KEY:
                return new Key(position);
            case DOOR:
                return new Door(position);
            case GUARD:
                return new Guard(position);
            case DOG:
                return new Dog(position);
            default:
                return new Player(position);
        }
    }
}