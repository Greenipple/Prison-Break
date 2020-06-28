package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.*;

public class Dog extends Entity {

    private boolean haveWall;

    public Dog(MapPosition position) {
        super(position, GameObjectType.DOG);
    }

    @Override
    public void move() {

        DirectionType direction = DirectionType.values()[(int) Math.floor(Math.random() * 4)];

        hitWall(direction);

        if (haveWall) {
            this.getPosition().moveInDirection(direction, 1);
            haveWall = false;
        }
    }

    public boolean hitWall(DirectionType directionType){

        if (directionType.equals(DirectionType.UP) && this.getPosition().getRow() != 9){
            return haveWall = true;
        }

        if (directionType.equals(DirectionType.DOWN) && this.getPosition().getRow() != 16){
            return haveWall = true;
        }

        if (directionType.equals(DirectionType.RIGHT) && this.getPosition().getCol() != 20){
            return haveWall = true;
        }

        if (directionType.equals(DirectionType.LEFT) && this.getPosition().getCol() != 10){
            return haveWall = true;
        }

        return false;
    }
}