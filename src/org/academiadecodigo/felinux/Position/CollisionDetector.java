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
    private Door[] doors;
    private int sightRange = 2;

    public CollisionDetector(GameObject[] objects){
        this.objects = objects;
    }
    public CollisionDetector(Player player, GameObject[] objects, Entity[] entities, Door[] doors) {
        this.player = player;
        this.objects = objects;
        this.entities = entities;
        this.doors = doors;
    }

    //Player is detected if he crashes into a guard or dog
    public void verify() {
        for (Entity entity : entities) {
            if (player.getPosition().getCol() == entity.getPosition().getCol() && player.getPosition().getRow() == entity.getPosition().getRow()) {
                player.gotDetected();
            }
        }
    }

    //Check if there's something ahead that blocks movement
    public boolean isMovementAllowed(MapPosition mapPosition, DirectionType direction){
        switch(direction) {

            case DOWN -> {

                for(int i = 0; i < objects.length; i++) {
                    if (mapPosition.getCol() == objects[i].getPosition().getCol() && mapPosition.getRow() == objects[i].getPosition().getRow() - 1) {
                        return false;
                    }
                }
/*
                for (int i = 0; i < doors.length; i++) {
                    if (mapPosition.getCol() == doors[i].getPosition().getCol() && mapPosition.getRow() == doors[i].getPosition().getRow() - 1 && doors[i].isShut()) {
                        return false;
                    }
                }*/
            }

            case UP -> {
                for (int i = 0; i < objects.length; i++) {
                    if(mapPosition.getCol() == objects[i].getPosition().getCol() && mapPosition.getRow() == objects[i].getPosition().getRow() + 1) {
                        return false;
                    }
                }
/*
                for (int i = 0; i < doors.length; i++) {
                    if (mapPosition.getCol() == doors[i].getPosition().getCol() &&  mapPosition.getRow() == doors[i].getPosition().getRow() + 1 && doors[i].isShut()) {
                        return false;
                    }
                }*/
            }

            case LEFT -> {
                for (int i = 0; i < objects.length; i++) {
                    if (mapPosition.getRow() == objects[i].getPosition().getRow() && mapPosition.getCol() == objects[i].getPosition().getCol() + 1) {
                        return false;
                    }
                }
/*
                for (int i = 0; i < doors.length; i++) {
                    if (mapPosition.getCol() == doors[i].getPosition().getCol() + 1 &&  mapPosition.getRow() == doors[i].getPosition().getRow() && doors[i].isShut()) {
                        return false;
                    }
                }*/
            }

            case RIGHT -> {
                for (int i = 0; i < objects.length; i++) {
                    if (mapPosition.getRow() == objects[i].getPosition().getRow() && mapPosition.getCol() == objects[i].getPosition().getCol()-1){
                        return false;
                    }
                }
/*
                for (int i = 0; i < doors.length; i++) {
                    if (mapPosition.getCol() == doors[i].getPosition().getCol() - 1 &&  mapPosition.getRow() == doors[i].getPosition().getRow() && doors[i].isShut()) {
                        return false;
                    }
                }*/
            }
        }
        return true;
    }

    //Guards line of sight checker
    public void lineOfSight(MapPosition position, DirectionType direction){
       /* switch (direction){
            case UP -> {
                //canSee turns false if it hits a wall;
                boolean canSeeCenterRow = true;
                boolean canSeeLeftRow = true;
                boolean canSeeRightRow = true;

                //center row;
                for (int i = 0; i < sightRange; i++) {
                    for (GameObject object : objects) {
                        if (object.getPosition().getCol() == position.getCol() && object.getPosition().getRow() == position.getRow() -i -1) {
                            canSeeCenterRow = false;
                            break;
                        }

                        if (player.getPosition().getCol() == position.getCol() && player.getPosition().getRow() == position.getRow() -i -1 && canSeeCenterRow){
                            player.gotDetected();
                        }
                    }
                }

            }
        }*/
        switch (direction){
            case LEFT -> {
                //this checks how far they can see
                int unblockedSightRange = sightRange;
                for(int i=1; i<=sightRange; i++){
                    for(GameObject object : objects){
                        if(object.getPosition().getRow() == position.getRow() && object.getPosition().getCol() == position.getCol() -i){
                            unblockedSightRange=i;
                        }
                    }
                }

                //now we look for player within unblockedSightRange
               // if(player.getPosition().getRow()== position.getRow() )
            }
        }
    }

    public void setPlayer (Player player){
        this.player = player;
    }
}