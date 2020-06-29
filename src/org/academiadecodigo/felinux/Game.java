package org.academiadecodigo.felinux;

import org.academiadecodigo.felinux.GameObject.DecorWall.*;
import org.academiadecodigo.felinux.GameObject.Entity.*;
import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.GameObject.Item.*;
import org.academiadecodigo.felinux.Position.*;

public class Game {

   public static final int DELAY = 400;
   private Map map;

   private GameObject[] blockArray = new GameObject[167];
   private GameObject wallBlock;
   private CollisionDetector collisionDetector;

   private Player player;
   private Entity[] movables;
   private Key key;
   private Barrel barrel;
   private Door[] doors;

   private int blockArrayIterator = 0;
   private int doorArrayIterator = 0;

    private int matrixPositions[][] = {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 2, 0, 0, 2, 2, 2, 0, 0, 2, 2, 2, 2, 0, 0, 2, 2, 2, 2},
            {2, 0, 8, 0, 0, 0, 2, 0, 0, 2, 2, 2, 0, 0, 2, 2, 2, 2, 0, 0, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 2},
            {2, 2, 5, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 5, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 4, 2},
            {2, 2, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {2, 0, 6, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 1},
            {2, 2, 2, 2, 2, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 1},
            {2, 0, 0, 0, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
   };

    public Game() {
        this.map = new Map();
        this.movables = new Entity[5];
        this.doors = new Door[5];
    }

    public void firstLevel() throws InterruptedException {

        this.init();

        while (!player.isDetected() && !player.hasWon()) {

            Thread.sleep(DELAY);

            this.moveAll();
        }
    }

    public void init() {
        collisionDetector = new CollisionDetector(blockArray);

        player = new Player(new MapPosition(2, 2,map),collisionDetector);
        collisionDetector.setPlayer(player);
        player.getPosition().show();

        //KEY
        key = new Key(new MapPosition(22,7, map),this.player);
        key.getPosition().show();

        //BARREL
        barrel = new Barrel(new MapPosition(1, 9, map),this.player);
        barrel.getPosition().show();

        //GUARDS
        movables[0] = new Guard(new MapPosition(21,4, map),1);
        movables[0].getPosition().show();

        movables[1] = new Guard(new MapPosition(2,10, map),2);
        movables[1].getPosition().show();

        //DOGS
        movables[2] = new Dog(new MapPosition(12,11,map), player);
        movables[2].getPosition().show();

        movables[3] = new Dog(new MapPosition(15,13,map), player);
        movables[3].getPosition().show();

        movables[4] = new Dog(new MapPosition(13,15,map), player);
        movables[4].getPosition().show();

        for (int i = 0; i < matrixPositions.length; i++) {
            for (int j = 0; j < matrixPositions[i].length; j++) {

                //FENCE
                if (matrixPositions[i][j] == 1) {
                    wallBlock = new Fence(new MapPosition(j , i, map));
                    blockArray[blockArrayIterator] = wallBlock;
                    blockArrayIterator++;
                    wallBlock.getPosition().show();
                }

                //WALL
                if (matrixPositions[i][j] == 2) {
                    wallBlock = new Wall(new MapPosition(j, i, map));
                    blockArray[blockArrayIterator]= wallBlock;
                    blockArrayIterator++;
                    wallBlock.getPosition().show();

                }

                //DOOR
                if (matrixPositions[i][j] == 5) {
                    wallBlock = new Door(new MapPosition(j, i, map),this.player);
                    doors[doorArrayIterator] = (Door) wallBlock;
                    doorArrayIterator++;
                    wallBlock.getPosition().show();

                }

            }
        }

        doors[2].shutDoor();

        collisionDetector = new CollisionDetector(this.player,this.movables,this.movables,this.doors);
    }


    public void moveAll() {

        barrel.move();

        key.store();

        for (Entity object : movables) {
            object.move();
        }

        collisionDetector.verify();

    }

    public GameObject[] getBlockArray() {
        return blockArray;
    }
}
