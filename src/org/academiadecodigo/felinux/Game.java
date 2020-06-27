package org.academiadecodigo.felinux;

import org.academiadecodigo.felinux.GameObject.Entity.*;
import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.GameObject.Item.Key;
import org.academiadecodigo.felinux.Position.*;
import org.academiadecodigo.felinux.Support.*;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Game {

   public static final int DELAY = 200;
   private GameObject wall;
   private Map map;
   private CollisionDetector collisionDetector;
   private GameObject[] blockArray = new GameObject[167];
   private int blockArrayIterator = 0;
   private int wallCount = 0;
   private int fenceCount = 0;
   private Player player;
   private GameObject[] movables = new GameObject[6];
   private Key key;

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
    }

    public void start() {
        this.init();
    }

    public void init() {

        player = (Player) GameObjectFactory.create(GameObjectType.PLAYER, new MapPosition(2, 2), map);
        player.getRectangle().setColor(Color.GREEN);
        player.getRectangle().fill();
        player.setCollisionDetector(collisionDetector);

        //BARREL
        movables[0] = GameObjectFactory.create(GameObjectType.BARREL, new MapPosition(1, 9), map);
        movables[0].getRectangle().setColor(Color.GRAY);
        movables[0].getRectangle().fill();

        //GUARDS


        for (int i = 0; i < matrixPositions.length; i++) {
            for (int j = 0; j < matrixPositions[i].length; j++) {
                //FENCE
                if (matrixPositions[i][j] == 1) {
                    wall = GameObjectFactory.create(GameObjectType.FENCE, new MapPosition(j , i), map);
                    fenceCount++;
                    blockArray[blockArrayIterator] = wall;
                    blockArrayIterator++;
                    wall.getRectangle().setColor(Color.DARK_GRAY);
                    wall.getRectangle().fill();
                }
                //WALL
                if (matrixPositions[i][j] == 2){
                    wall = GameObjectFactory.create(GameObjectType.WALL, new MapPosition(j, i), map);
                    wallCount++;
                    blockArray[blockArrayIterator]=wall;
                    blockArrayIterator++;
                    wall.getRectangle().setColor(Color.BLACK);
                    wall.getRectangle().fill();

                }

                //KEY
                if (matrixPositions[i][j] == 4) {
                    wall = GameObjectFactory.create(GameObjectType.KEY, new MapPosition(j, i), map);
                    wall.getRectangle().setColor(Color.YELLOW);
                    wall.getRectangle().fill();

                }

                //DOOR
                if (matrixPositions[i][j] == 5) {
                    wall = GameObjectFactory.create(GameObjectType.DOOR, new MapPosition(j, i), map);
                    wall.getRectangle().setColor(Color.LIGHT_GRAY);
                    wall.getRectangle().fill();
                }

                //GUARD
                /*if (wallPostions[i][j] == 6) {
                    wall = GameObjectFactory.create(GameObjectType.GUARD, new MapPosition(j, i, map, this));
                    wall.getRectangle().setColor(Color.BLUE);
                    wall.getRectangle().fill();

                }*/

                //DOG
/*                if (wallPostions[i][j] == 7) {
                    wall = GameObjectFactory.create(GameObjectType.DOG, new MapPosition(j, i, map));
                    wall.getRectangle().setColor(Color.PINK);
                    wall.getRectangle().fill();
                }*/

                }
            }

            Guard guard1 = new Guard(new MapPosition(21,4), map);
            guard1.getRectangle().setColor(Color.BLUE);
            guard1.getRectangle().fill();

            GameObject dog = new Dog(new MapPosition(12, 11), map);
            dog.getRectangle().fill();
            int count = 50;

            while (count > 0) {
            //Thread.sleep(100);

                if (dog instanceof Dog) {
                    ((Dog) dog).move();
                }

                count--;
            }



        System.out.println("Walls: " + wallCount);
        System.out.println(("Fences: " + fenceCount));

        while(!player.isDetected()) {
            Route.guard1Move(guard1);

        }
    }


    public void movePrisioners(){
    }

    public GameObject[] getBlockArray() {
        return blockArray;
    }
}
