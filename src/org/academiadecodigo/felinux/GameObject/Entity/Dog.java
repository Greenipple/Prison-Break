package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.Position.CollisionDetector;
import org.academiadecodigo.felinux.Position.Map;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.DirectionType;
import org.academiadecodigo.felinux.Support.GameObjectType;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.regex.Matcher;

public class Dog extends Entity {

    MapPosition mapPosition;
    Map map;

    public Dog(MapPosition position, Map map) {
        super(position, GameObjectType.DOG, map);
    }

    @Override
    public void setCollisionDetector(CollisionDetector collisionDetector) {

    }

    @Override
    public void move() {

        //int direction = (int) Math.floor(Math.random()*4);
        int direction = 2;
/*        Rectangle koi = new Rectangle(15, 15, Map.CELL_SIZE, Map.CELL_SIZE);
        koi.fill();*/

        switch (direction){
            case 0:
                //this.getRectangle().translate(40,0);
                //System.out.println("1");
                //mapPosition.moveInDirection(DirectionType.RIGHT,40, this.getRectangle());
                break;
            case 1:
                //this.getRectangle().translate(-40,0);
                //System.out.println("2");
                //mapPosition.moveInDirection(DirectionType.LEFT, 40, this.getRectangle());
                break;
            case 2:
                System.out.println("3");
                //this.getRectangle().translate(0,-40);
                mapPosition.moveInDirection(DirectionType.UP,40);
                break;
            default:
                //this.getRectangle().translate(0,40);
                //System.out.println("4");
                //mapPosition.moveInDirection(DirectionType.DOWN, 40, this.getRectangle());
                break;
        }








    }
}
