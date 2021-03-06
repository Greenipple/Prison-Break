package org.academiadecodigo.felinux.Position;

import org.academiadecodigo.felinux.GameObject.Entity.*;
import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.GameObject.Item.*;
import org.academiadecodigo.felinux.Support.DirectionType;

public class CollisionDetector {

    private Player player;
    private GameObject[] objects; // Walls & fences
    private Entity[] entities;
    private Door[] doors;
    private int sightRange = 5;

    public CollisionDetector() {

    }

    public CollisionDetector(Player player, GameObject[] objects, Entity[] entities, Door[] doors) {
        this.player = player;
        this.objects = objects;
        this.entities = entities;
        this.doors = doors;
    }

    //Player is detected igit adf he crashes into a guard or dog
    public void verify() {
        for (Entity entity : entities) {
            if (player.getPosition().getCol() == entity.getPosition().getCol() && player.getPosition().getRow() == entity.getPosition().getRow()) {
                player.gotDetected();
            }
        }
    }

    //Check if there's something ahead that blocks movement
    public boolean isMovementAllowed(MapPosition mapPosition, DirectionType direction) {

        switch(direction) {
            case DOWN -> {
                for (int i = 0; i < objects.length; i++) {
                    if (mapPosition.getCol() == objects[i].getPosition().getCol() && mapPosition.getRow() == objects[i].getPosition().getRow() - 1) {
                        return false;
                    }
                }
            }
            case UP -> {
                for (int i = 0; i < objects.length; i++) {
                    if (mapPosition.getCol() == objects[i].getPosition().getCol() && mapPosition.getRow() == objects[i].getPosition().getRow() + 1) {
                        return false;
                    }
                }
            }
            case LEFT -> {
                for (int i = 0; i < objects.length; i++) {
                    if (mapPosition.getRow() == objects[i].getPosition().getRow() && mapPosition.getCol() == objects[i].getPosition().getCol() + 1) {
                        return false;
                    }
                }
            }
            case RIGHT -> {
                for (int i = 0; i < objects.length; i++) {
                    if (mapPosition.getRow() == objects[i].getPosition().getRow() && mapPosition.getCol() == objects[i].getPosition().getCol() - 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isDoorAhead(MapPosition mapPosition, DirectionType direction) {
        //Also checks for shut doors
        for (int i = 0; i < doors.length; i++) {
            if (doors[i].isShut()) {
                switch(direction) {
                    case DOWN:
                        if (mapPosition.getCol() == doors[i].getPosition().getCol() && mapPosition.getRow() == doors[i].getPosition().getRow() - 1 && doors[i].isShut()) {
                            return false;
                        }
                        break;

                    case UP:
                        if (mapPosition.getCol() == doors[i].getPosition().getCol() && mapPosition.getRow() == doors[i].getPosition().getRow() + 1 && doors[i].isShut()) {
                            return false;
                        }
                        break;
                    case LEFT:

                        if (mapPosition.getCol() == doors[i].getPosition().getCol() + 1 && mapPosition.getRow() == doors[i].getPosition().getRow() && doors[i].isShut()) {
                            return false;
                        }
                        break;
                    case RIGHT:
                        if (mapPosition.getCol() == doors[i].getPosition().getCol() - 1 && mapPosition.getRow() == doors[i].getPosition().getRow() && doors[i].isShut()) {
                            return false;
                        }
                        break;
                }
            }
        }
        return true;
    }

    //Guards line of sight checker
    public void lineOfSight(MapPosition position, DirectionType direction){

        if (!player.isHidden()) {
            switch (direction) {

                case LEFT -> {
                    /**this checks how far they can see**/
                    int unblockedSightRange = sightRange;
                    boolean wallSpotted = false;


                    for (int i = 0; i < sightRange && !wallSpotted; i++) {
                        for (GameObject object : objects) {
                            if (object.getPosition().getRow() == position.getRow() && object.getPosition().getCol() == position.getCol() - i) {
                                unblockedSightRange = i;
                                wallSpotted = true;
                                break;
                            }
                        }
                    }

                    /**now we look for player within unblockedSightRange**/
                    for (int j = 0; j < unblockedSightRange; j++) {
                        if (player.getPosition().getCol() == position.getCol() - j &&
                                (player.getPosition().getRow() == position.getRow() || player.getPosition().getRow() == position.getRow() + 1 || player.getPosition().getRow() == position.getRow() - 1)) {
                            player.gotDetected();
                        }
                    }
                }

                case RIGHT -> {
                    int unblockedSightRange = sightRange;
                    boolean wallSpotted = false;

                    for (int i = 0; i < sightRange && !wallSpotted; i++) {
                        for (GameObject object : objects) {
                            if (object.getPosition().getRow() == position.getRow() && object.getPosition().getCol() == position.getCol() + i) {
                                unblockedSightRange = i;
                                wallSpotted = true;
                                break;
                            }
                        }
                    }

                    for (int j = 0; j < unblockedSightRange; j++) {
                        if (player.getPosition().getCol() == position.getCol() + j &&
                                (player.getPosition().getRow() == position.getRow() || player.getPosition().getRow() == position.getRow() + 1 || player.getPosition().getRow() == position.getRow() - 1)) {
                            player.gotDetected();
                        }
                    }


                }

                case UP -> {
                    int unblockedSightRange = sightRange;
                    boolean wallSpotted = false;

                    for (int i = 0; i < sightRange && !wallSpotted; i++) {
                        for (GameObject object : objects) {
                            if (object.getPosition().getRow() == position.getRow() - i && object.getPosition().getCol() == position.getCol()) {
                                unblockedSightRange = i;
                                wallSpotted = true;
                                break;
                            }
                        }
                    }

                    for (int j = 0; j < unblockedSightRange; j++) {
                        if (player.getPosition().getRow() == position.getRow() - j &&
                                (player.getPosition().getCol() == position.getCol() || player.getPosition().getCol() == position.getCol() + 1 || player.getPosition().getCol() == position.getCol() - 1)) {
                            player.gotDetected();
                        }
                    }
                }

                case DOWN -> {

                    int unblockedSightRange = sightRange;
                    boolean wallSpotted = false;

                    for (int i = 0; i < sightRange && !wallSpotted; i++) {
                        for (GameObject object : objects) {
                            if (object.getPosition().getRow() == position.getRow() + i && object.getPosition().getCol() == position.getCol()) {
                                unblockedSightRange = i;
                                wallSpotted = true;
                                break;
                            }
                        }
                    }

                    for (int j = 0; j < unblockedSightRange; j++) {
                        if (player.getPosition().getRow() == position.getRow() + j &&
                                (player.getPosition().getCol() == position.getCol() || player.getPosition().getCol() == position.getCol() + 1 || player.getPosition().getCol() == position.getCol() - 1)) {
                            player.gotDetected();
                        }
                    }

                }
            }
        }
    }

    //Check place to drop barrel
    public void barrelDropCheck(){

        if (player.hasBarrel() && player.getPosition().getCol() == 7 && player.getPosition().getRow() == 16) {
            player.dropBarrel();
            player.getPosition().show();

            System.out.println("DROP MUTHAFUCKAAAAA");
        }
    }

    public void setPlayer (Player player){
        this.player = player;
    }

    public void setDoors (Door[] doors) {
        this.doors = doors;

        for (int i = 0; i < doors.length; i++) {
            doors[i].getPosition().show();
        }
    }
}