package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.*;

public class Dog extends Entity {
    public Dog(MapPosition position) {
        super(position, GameObjectType.DOG);
    }

    @Override
    public void move() {

        DirectionType direction = DirectionType.values()[(int) Math.floor(Math.random()*4)];
/*        Rectangle koi = new Rectangle(15, 15, Map.CELL_SIZE, Map.CELL_SIZE);
        koi.fill();*/

        switch (direction) {
            case UP:

                this.getPosition().moveInDirection(DirectionType.UP,1);
                //this.getRectangle().translate(0,-Map.CELL_SIZE);
                //this.getRectangle().translate(40,0);
                //System.out.println("1");
                //mapPosition.moveInDirection(DirectionType.UP,40, this.getRectangle());
                break;
            case RIGHT:
                this.getPosition().moveInDirection(DirectionType.RIGHT,1);
                //this.getRectangle().translate(Map.CELL_SIZE,0);
                //this.getRectangle().translate(-40,0);
                //System.out.println("2");
                //mapPosition.moveInDirection(DirectionType.LEFT, 40, this.getRectangle());
                break;
            case DOWN:
                this.getPosition().moveInDirection(DirectionType.DOWN,1);
                //this.getRectangle().translate(0,Map.CELL_SIZE);
                //System.out.println("3");
                //this.getRectangle().translate(0,-40);
                //mapPosition.moveInDirection(DirectionType.UP,40);
                break;
            default:
                this.getPosition().moveInDirection(DirectionType.LEFT,1);
                //this.getRectangle().translate(-Map.CELL_SIZE,0);
                //this.getRectangle().translate(0,40);
                //System.out.println("4");
                //mapPosition.moveInDirection(DirectionType.DOWN, 40, this.getRectangle());
                break;
        }
    }
}
