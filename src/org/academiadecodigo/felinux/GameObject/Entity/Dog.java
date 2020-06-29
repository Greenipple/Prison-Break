package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.*;


public class Dog extends Entity {

    private boolean haveWall;
    private Player player;
    private boolean arrive;

    public Dog(MapPosition position, Player player) {
        super(position, GameObjectType.DOG);
        this.player = player;
    }

    @Override
    public void move() {

        DirectionType direction = DirectionType.values()[(int) Math.floor(Math.random() * 4)];

        playerArrived();
        if(arrive){
            followPlayer();
        }
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

    public boolean playerArrived(){
        if (player.getPosition().getCol() == 10 && player.getPosition().getRow() == 16){
            return arrive = true;
        }
        return false;
    }

    public void followPlayer(){

        if(arrive){
            if(player.getPosition().getCol() != this.getPosition().getCol() && player.getPosition().getCol() < this.getPosition().getCol()){
                this.getPosition().moveInDirection(DirectionType.LEFT, 1);
            }
            if(player.getPosition().getCol() != this.getPosition().getCol() && player.getPosition().getCol() > this.getPosition().getCol()){
                this.getPosition().moveInDirection(DirectionType.RIGHT, 1);
            }
            if(player.getPosition().getRow() != this.getPosition().getRow() && player.getPosition().getRow() > this.getPosition().getRow()){
                this.getPosition().moveInDirection(DirectionType.DOWN, 1);
            }
            if(player.getPosition().getRow() != this.getPosition().getRow() && player.getPosition().getRow() > this.getPosition().getRow()){
                this.getPosition().moveInDirection(DirectionType.DOWN, 1);
            }
        }
    }
}