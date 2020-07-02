package org.academiadecodigo.felinux;

import org.academiadecodigo.felinux.GameObject.DecorWall.*;
import org.academiadecodigo.felinux.GameObject.Entity.*;
import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.GameObject.Item.*;
import org.academiadecodigo.felinux.Position.*;
import org.academiadecodigo.felinux.Support.MenuHandler;

public class Game {

   public static final int DELAY = 400;
   private Map map;
   private Map startScreen;
   private Map loadingScreen;
   private Map gameOver;
   private Map theEnd;
   private MenuHandler menuHandler;

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
   private Sound startMusic;
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
        //this.startScreen = new Map("resources/startingScreen/start-screen.png");
        //this.loadingScreen = new Map("");
        this.startMusic=new Sound("/resources/Sounds/level.wav");
        this.map = new Map("resources/map/map.png");
        this.gameOver = new Map("resources/caughtScreen/gotCaught.png");
        this.theEnd = new Map("resources/wonScreen/wonScreen.png");
        this.movables = new Entity[5];
        this.doors = new Door[5];
        this.menuHandler = new MenuHandler(this);
    }

    public void start() throws InterruptedException {

        this.menuHandler.init();

        startMusic.play(true);

        while(!menuHandler.isStartGame()) {
            this.startScreen();
        }

        this.loadingScreen();

        this.firstLevel();

        if (player.isDetected()) {
            menuHandler.setStartGame();
            while (!menuHandler.isStartGame()) {
                this.gameOver.show();
            }
            this.restart();
            this.player.setDetected(false);
            this.start();
        }

        if (player.hasWon()) {
            menuHandler.setStartGame();
            while(!menuHandler.isStartGame()) {
                this.map.hidde();
                this.theEnd.show();
            }
            //this.restart();
            this.player.setDetected(false);
            this.player.setWonLevel(false);
            this.start();
        }

        //this.init();


/*        while(this.player.getAction()) {
            this.loadingScreen();
        }*/

        //this.firstLevel(); //gameOver() & theEnd() will be called by firstLevel()

    }

    public void startScreen() {
        startScreen = new Map("resources/startingScreen/starting-screen.png");
        startScreen.show();

/*        if(player.getStartGame()){
            startScreen.hidde();
        }*/
    }

    public void loadingScreen() {
        loadingScreen = new Map("resources/loadingScreen/loading.png");
        startScreen.hidde();
        loadingScreen.show();
        timer();
        loadingScreen.hidde();
    }

    public void firstLevel() throws InterruptedException {

        map.show();

        this.init();

        while (!player.isDetected() && !player.hasWon()) {

            Thread.sleep(DELAY);

            this.moveAll();
        }
    }

    public void gameOver() {

    }

    public void theEnd() {

    }

    public void init() {

        this.collisionDetector = new CollisionDetector(blockArray,doors);
        this.player = new Player(new MapPosition(2, 2,map),collisionDetector);
        //collisionDetector.setPlayer(player);
        player.getPosition().show();

        //KEY
        key = new Key(new MapPosition(22,7, map),this.player);
        key.getPosition().show();
        player.setKey(key);

        //BARREL
        barrel = new Barrel(new MapPosition(1, 9, map),this.player);
        barrel.getPosition().show();
        player.setBarrel(barrel);

        //GUARDS
        movables[0] = new Guard(new MapPosition(21,4, map),1);
        movables[0].getPosition().show();

        movables[1] = new Guard(new MapPosition(2,10, map),2);
        movables[1].getPosition().show();

        //DOGS
        movables[2] = new Dog(new MapPosition(12,11,map), this.player);
        movables[2].getPosition().show();

        movables[3] = new Dog(new MapPosition(15,13,map), this.player);
        movables[3].getPosition().show();

        movables[4] = new Dog(new MapPosition(13,15,map), this.player);
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
                    doors[doorArrayIterator] = new Door(new MapPosition(j, i, map),this.player);
                    doorArrayIterator++;
                    wallBlock.getPosition().show();
                }
            }
        }

        doors[2].shutDoor();
        collisionDetector = new CollisionDetector(this.player,this.blockArray,this.movables,this.doors);

        this.player.setDoor(doors[2]);
        this.player.setCollisionDetector(collisionDetector);
        collisionDetector.setDoors(this.doors);
    }

    public void moveAll() {

        player.checkWin();

       // key.check();
        //doors[2].check();
        //player.setAction(false);

        barrel.move();

        for (Entity object : movables) {
            object.move();
        }

        collisionDetector.lineOfSight(movables[0].getPosition(), movables[0].getPosition().getFacing());
        collisionDetector.lineOfSight(movables[1].getPosition(),movables[1].getPosition().getFacing());

        collisionDetector.verify();

    }
    public CollisionDetector getCollisionDetector(){
        return this.collisionDetector;
    }
    public GameObject[] getBlockArray() {
        return blockArray;
    }

   public void timer(){
       for (int i = 5; i > 0; i--) {
           try {
               Thread.sleep(1000);
           }catch (InterruptedException e){
               e.printStackTrace();
           }
       }
   }

   public void restart(){
        this.map.hidde();
        this.gameOver.hidde();
        this.theEnd.hidde();
        this.player.getPosition().hide();
        this.barrel.getPosition().hide();
        this.player.setHasKey(false);
        this.key.getPosition().hide();
        for (Entity movable : movables){
            movable.getPosition().hide();
        }
        for (GameObject gameObject : blockArray){
            gameObject.getPosition().hide();
        }
       blockArrayIterator = 0;
       doorArrayIterator = 0;
   }
}
