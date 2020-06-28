package org.academiadecodigo.felinux.Position;

import org.academiadecodigo.felinux.GameObject.Entity.*;
import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.GameObject.Item.*;
import org.academiadecodigo.felinux.Support.DirectionType;

import java.util.Arrays;

public class CollisionDetector {
    private Player player;
    private GameObject[] objects; // Walls & fences
    private Entity[] entities;
    private Key key;
    private Barrel barrel;

    public CollisionDetector(GameObject[] objects){
        this.objects = objects;
    }
    public CollisionDetector(Player player, GameObject[] objects) {
        this.player = player;
        this.objects = objects;
    }

    public void verify() {
        for (GameObject object : objects) {
            if (player.getPosition() == object.getPosition()) {
                if (object instanceof Guard || object instanceof Dog) {
                    player.gotDetected(); //player is detected if he crashes into a guard or dog
                }

                if (object instanceof Barrel) {
                    Barrel barrel = (Barrel) object;
                    barrel.beenHold();
                }

                if (object instanceof Key) {
                    Key key = (Key) object;
                    key.beenHold();
                }
            }
        }
    }



    //Check if there's something ahead that blocks movement
    public boolean isMovementAllowed(MapPosition mapPosition, DirectionType direction){
        switch(direction){
            case DOWN -> {
                for(int i=0; i<objects.length; i++){
                    if(mapPosition.getCol() == objects[i].getPosition().getCol() &&  mapPosition.getRow() == objects[i].getPosition().getRow()-1){
                        return false;
                    }
                }
            }

            case UP -> {
                for (int i=0; i<objects.length; i++){
                    if(mapPosition.getCol() == objects[i].getPosition().getCol() && mapPosition.getRow() == objects[i].getPosition().getRow()+1){
                        return false;
                    }
                }
            }

            case LEFT -> {
                for (int i=0; i<objects.length; i++){
                    if (mapPosition.getRow() == objects[i].getPosition().getRow() && mapPosition.getCol() == objects[i].getPosition().getCol()+1){
                        return false;
                    }
                }
            }

            case RIGHT -> {
                for (int i=0; i<objects.length; i++){
                    if (mapPosition.getRow() == objects[i].getPosition().getRow() && mapPosition.getCol() == objects[i].getPosition().getCol()-1){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    //Guards line of sight checker
    public void lineOfSight(MapPosition position, DirectionType direction){
        System.out.println(player);
    }
}