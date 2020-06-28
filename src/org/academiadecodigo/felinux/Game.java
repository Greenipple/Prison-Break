package org.academiadecodigo.felinux;

import org.academiadecodigo.felinux.GameObject.DecorWall.*;
import org.academiadecodigo.felinux.GameObject.Entity.*;
import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.GameObject.Item.*;
import org.academiadecodigo.felinux.Position.*;

public class Game {

   public static final int DELAY = 400;
   private GameObject walls;
   private Map map;
   private CollisionDetector collisionDetector;
   private GameObject[] blockArray = new GameObject[167];
   private int blockArrayIterator = 0;
   private int wallCount = 0;
   private int fenceCount = 0;

   private Player player;
   private Entity[] movables;
   private Key key;
   private Barrel barrel;

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

    public Game(){
        this.map = new Map();
        this.movables = new Entity[5];
    }

    public void start() throws InterruptedException {

        this.init();

        while (!player.isDetected()) {
            Thread.sleep(DELAY);

            this.moveAll();

            /*
            if (movables[3] instanceof Dog) {
                Dog dog1 = (Dog) movables[3];
                Thread.sleep(200);
                dog1.move();
            }
            if (movables[4] instanceof Dog) {
                Dog dog2 = (Dog) movables[4];
                Thread.sleep(200);
                dog2.move();
            }
            if (movables[5] instanceof Dog) {
                Dog dog3 = (Dog) movables[5];
                Thread.sleep(200);
                dog3.move();
            }
            Route.guard1Move((Guard) movables[1]);*/
        }

/*        while(!player.isDetected()) {

            int count = 10;

            while (count > 0) {

                if (movables[3] instanceof Dog) {
                    Dog dog1 = (Dog) movables[3];
                    dog1.move();
                }

                count--;
            }

            Route.guard1Move((Guard) movables[1]);

            *//* PODE PASSAR A MÉTODO DESTA CLASSE
            for (int i = 0; i < movables.length; i++) {

                collisionDetector.verify();

                if (movables[i] instanceof Barrel) {
                    (Barrel) movables[i].move(player.getPosition());
                }
                if (movables[i] instanceof Guard) {
                    (Guard) movables[i].move();
                }
                if (movables[i]. instanceof Dog) {
                    (Dog) movables[i].move();
                }
            }
            *//*


        }*/
    }

    public void init() {

        player = new Player(new MapPosition(2, 2,map));
        //player.getPosition().setRectangle(player.getPosition().getRectangle());
        //player.getPosition().getRectangle().setColor(Color.GREEN);
        player.getPosition().show();

        //KEY
        key = new Key(new MapPosition(22,7, map),this.player);
        //key.getPosition().getRectangle().setColor(Color.YELLOW);
        key.getPosition().show();

        //BARREL
        barrel = new Barrel(new MapPosition(1, 9, map),this.player);
        //movables[0].getPosition().getRectangle().setColor(Color.GRAY);
        barrel.getPosition().show();

        //GUARDS
        movables[0] = new Guard(new MapPosition(21,4, map),1);
        //movables[1].getRectangle().setColor(Color.BLUE);
        movables[0].getPosition().show();

        movables[1] = new Guard(new MapPosition(2,10, map),2);
        //movables[2].getRectangle().setColor(Color.BLUE);
        movables[1].getPosition().show();

        //DOGS
        movables[2] = new Dog(new MapPosition(12,11,map));
        //movables[3].getPosition().setRectangle(movables[3].getRectangle());
        //movables[3].getRectangle().setColor(Color.RED);
        movables[2].getPosition().show();

        movables[3] = new Dog(new MapPosition(15,13,map));
        //movables[4].getPosition().setRectangle(movables[4].getRectangle());
        //movables[4].getRectangle().setColor(Color.RED);
        movables[3].getPosition().show();

        movables[4] = new Dog(new MapPosition(13,15,map));
        //movables[5].getPosition().setRectangle(movables[5].getRectangle());
        //movables[5].getRectangle().setColor(Color.RED);
        movables[4].getPosition().show();
        //...

        for (int i = 0; i < matrixPositions.length; i++) {
            for (int j = 0; j < matrixPositions[i].length; j++) {

                //FENCE
                if (matrixPositions[i][j] == 1) {
                    walls = new Fence(new MapPosition(j , i, map));
                    fenceCount++;
                    blockArray[blockArrayIterator] = walls;
                    blockArrayIterator++;
                    //wall.getRectangle().setColor(Color.DARK_GRAY);
                    walls.getPosition().show();
                }

                //WALL
                if (matrixPositions[i][j] == 2) {
                    walls = new Wall(new MapPosition(j, i, map));
                    wallCount++;
                    blockArray[blockArrayIterator]= walls;
                    blockArrayIterator++;
                    //wall.getRectangle().setColor(Color.BLACK);
                    walls.getPosition().show();

                }

                //DOOR
                if (matrixPositions[i][j] == 5) {
                    walls = new Door(new MapPosition(j, i, map),this.player);
                    //wall.getRectangle().setColor(Color.LIGHT_GRAY);
                    walls.getPosition().show();
                }
            }
        }

        collisionDetector = new CollisionDetector(this.player,this.movables);

        System.out.println("Walls: " + wallCount);
        System.out.println(("Fences: " + fenceCount));
    }


    public void moveAll() {

        for (Entity object : movables) {
            object.move();
        }

        barrel.move();
    }

    public GameObject[] getBlockArray() {
        return blockArray;
    }
}
