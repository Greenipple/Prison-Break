package org.academiadecodigo.felinux;

import org.academiadecodigo.felinux.GameObject.DecorWall.Wall;
import org.academiadecodigo.felinux.GameObject.Entity.Player;
import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.Position.CollisionDetector;
import org.academiadecodigo.felinux.Position.Map;
import org.academiadecodigo.felinux.Position.MapPosition;
import org.academiadecodigo.felinux.Support.GameObjectFactory;
import org.academiadecodigo.felinux.Support.GameObjectType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class Game {

   public static final int DELAY = 200;
   private GameObject wall;
   private Map map;
   private CollisionDetector collisionDetector;
   private GameObject[] blockArray = new GameObject[167];
   private int blockArrayIterator = 0;
   private int wallCount = 0;
   private int fenceCount = 0;


    private int wallPostions[][] = {
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


    public void start(){

    }


    public void init(){



        for (int i = 0; i < wallPostions.length; i++){
            for (int j = 0; j < wallPostions[i].length; j++){
                //FENCE
                if (wallPostions[i][j] == 1){
                    wall = GameObjectFactory.create(GameObjectType.FENCE, new MapPosition(j , i , map , this));
                    fenceCount++;
                    blockArray[blockArrayIterator] = wall;
                    blockArrayIterator++;
                    wall.getRectangle().setColor(Color.DARK_GRAY);
                    wall.getRectangle().fill();
                }
                //WALL
                if (wallPostions[i][j] == 2){
                    wall = GameObjectFactory.create(GameObjectType.WALL, new MapPosition(j  , i , map, this));
                    wallCount++;
                    blockArray[blockArrayIterator]=wall;
                    blockArrayIterator++;
                    wall.getRectangle().setColor(Color.BLACK);
                    wall.getRectangle().fill();

                }

                //BARREL
                if (wallPostions[i][j] == 3){
                    wall = GameObjectFactory.create(GameObjectType.BARREL, new MapPosition(j  , i , map, this));
                    wall.getRectangle().setColor(Color.GRAY);
                    wall.getRectangle().fill();
                }

                //KEY
                if (wallPostions[i][j] == 4) {
                    wall = GameObjectFactory.create(GameObjectType.KEY, new MapPosition(j, i, map, this));
                    wall.getRectangle().setColor(Color.YELLOW);
                    wall.getRectangle().fill();

                }

                //DOOR
                if (wallPostions[i][j] == 5) {
                    wall = GameObjectFactory.create(GameObjectType.DOOR, new MapPosition(j, i, map, this));
                    wall.getRectangle().setColor(Color.LIGHT_GRAY);
                    wall.getRectangle().fill();
                }

                //GUARD
                if (wallPostions[i][j] == 6) {
                    wall = GameObjectFactory.create(GameObjectType.GUARD, new MapPosition(j, i, map, this));
                    wall.getRectangle().setColor(Color.BLUE);
                    wall.getRectangle().fill();
                }

                //DOG
                if (wallPostions[i][j] == 7) {
                    wall = GameObjectFactory.create(GameObjectType.DOG, new MapPosition(j, i, map, this));
                    wall.getRectangle().setColor(Color.PINK);
                    wall.getRectangle().fill();
                }

                //PLAYER
                if (wallPostions[i][j] == 8) {
                    wall = GameObjectFactory.create(GameObjectType.PLAYER, new MapPosition(j, i, map, this));
                    wall.getRectangle().setColor(Color.GREEN);
                    wall.getRectangle().fill();

                    //Player player = new Player(new MapPosition(j, i, map));
                    //player.getPosition().setColor(Color.GREEN);
                    //player.setCollisionDetector(collisionDetector);
                }
            }
        }

        System.out.println("Walls: " + wallCount);
        System.out.println(("Fences: " + fenceCount));

    }


    public void movePrisioners(){
    }

    public GameObject[] getBlockArray() {
        return blockArray;
    }
}
