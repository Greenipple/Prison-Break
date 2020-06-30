package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.*;


public class Dog extends Entity {

    private Player player;
    private boolean arrive;

    public Dog(MapPosition position, Player player) {
        super(position, GameObjectType.DOG);
        this.player = player;
    }

    @Override
    public void move() {

        DirectionType direction = DirectionType.values()[(int) Math.floor(Math.random() * 4)];

        checkPlayer();

        if (arrive) {
            followPlayer();
            return;
        }

        dogMove(direction);

    }

    public void dogMove(DirectionType directionType){
        //if dog is beside a wall, it won't move towards it
        if ( (directionType.equals(DirectionType.UP) && this.getPosition().getRow() != 9) ||
                (directionType.equals(DirectionType.DOWN) && this.getPosition().getRow() != 16) ||
                (directionType.equals(DirectionType.RIGHT) && this.getPosition().getCol() != 22) ||
                (directionType.equals(DirectionType.LEFT) && this.getPosition().getCol() != 10) ) {

            this.getPosition().moveInDirection(directionType, 1);

        }
    }

    public boolean checkPlayer(){
        if (player.getPosition().getCol() >= 10 && player.getPosition().getRow() <= 16 && player.getPosition().getRow() >= 9){
            return arrive = true;
        }
        return arrive = false;
    }

    public void followPlayer(){

        if(player.getPosition().getCol() != this.getPosition().getCol() && player.getPosition().getCol() < this.getPosition().getCol() && this.getPosition().getCol() != 10){
            this.getPosition().moveInDirection(DirectionType.LEFT, 1);
        }
        if(player.getPosition().getCol() != this.getPosition().getCol() && player.getPosition().getCol() > this.getPosition().getCol() && this.getPosition().getCol() != 22){
            this.getPosition().moveInDirection(DirectionType.RIGHT, 1);
        }
        if(player.getPosition().getRow() != this.getPosition().getRow() && player.getPosition().getRow() > this.getPosition().getRow() && this.getPosition().getRow() != 16){
            this.getPosition().moveInDirection(DirectionType.DOWN, 1);
        }
        if(player.getPosition().getRow() != this.getPosition().getRow() && player.getPosition().getRow() < this.getPosition().getRow() && this.getPosition().getRow() != 9){
            this.getPosition().moveInDirection(DirectionType.UP, 1);
        }
    }
}