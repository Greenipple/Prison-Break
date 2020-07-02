package org.academiadecodigo.felinux;

import org.academiadecodigo.felinux.GameObject.DecorWall.*;
import org.academiadecodigo.felinux.GameObject.Entity.*;
import org.academiadecodigo.felinux.GameObject.GameObject;
import org.academiadecodigo.felinux.GameObject.Item.*;
import org.academiadecodigo.felinux.Position.*;
import org.academiadecodigo.felinux.Support.DirectionType;
import org.academiadecodigo.felinux.Support.MenuHandler;

import javax.swing.text.Position;

public class Game {

   public static final int DELAY = 400;
   private Map map;
   private Map startScreen;
   private Map loadingScreen;
   private Map gameOver;
   private Map theEnd;
   private MenuHandler menuHandler;

   private GameObject[] blockArray;
   private CollisionDetector collisionDetector;

   private Player player;
   private Entity[] movables;
   private Key key;
   private Barrel barrel;
   private Door[] doors;

   private int blockArrayIterator = 0;
   private int doorArrayIterator = 0;
   private Sound startMusic;
   private Sound levelMusic;
   private Sound gameOverMusic;
   private Sound endGameMusic;



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
        /*this.endGameMusic = new Sound ("/resources/Sounds/end-music.wav");
        this.gameOverMusic = new Sound("/resources/Sounds/game-over.wav");
        this.levelMusic = new Sound("/resources/Sounds/level.wav");
        this.startMusic=new Sound("/resources/Sounds/menu.wav");
        this.map = new Map("resources/map/map.png");
        this.gameOver = new Map("resources/caughtScreen/gotCaught.png");
        this.theEnd = new Map("resources/wonScreen/wonScreen.png");
        this.movables = new Entity[5];
        this.doors = new Door[5];*/
    }

    public void start() throws InterruptedException {

        newAssets();

        menuHandler.init();

        startMusic.play(true);

        while(!menuHandler.isStartGame()) {
            this.startScreen();
        }

        loadingScreen();

        startMusic.stop();

        levelMusic.play(true);

        firstLevel();

        gameOver();

        theEnd();

    }

    public void startScreen() {

        startScreen = new Map("resources/startingScreen/starting-screen.png");
        startScreen.show();

    }

    public void loadingScreen() {

        loadingScreen = new Map("resources/loadingScreen/loading.png");
        startScreen.hide();
        loadingScreen.show();
        timer();
        loadingScreen.hide();

    }

    public void firstLevel() throws InterruptedException {

        map.show();

        this.init();

        while (!player.isDetected() && !player.hasWon()) {

            Thread.sleep(DELAY);

            this.moveAll();
        }
    }

    public void gameOver() throws InterruptedException {

        if (player.isDetected()) {

            levelMusic.stop();
            gameOverMusic.play(true);
            this.player.setPosition(new MapPosition(-1,-1,gameOver));

            menuHandler.setStartGame();

            while (!menuHandler.isStartGame()) {
                this.gameOver.show();
            }

            this.restart();
            this.start();
        }
    }

    public void theEnd() throws InterruptedException {
        if (player.hasWon()) {
            levelMusic.stop();
            endGameMusic.play(true);
            this.player.setPosition(new MapPosition(0,0,theEnd));

            menuHandler.setStartGame();


            while (!menuHandler.isStartGame()) {
                this.map.hide();
                this.theEnd.show();
            }

            this.restart();
            this.start();
        }
    }

    public void newAssets() {
        this.endGameMusic = new Sound ("/resources/Sounds/end-music.wav");
        this.gameOverMusic = new Sound("/resources/Sounds/game-over.wav");
        this.levelMusic = new Sound("/resources/Sounds/level.wav");
        this.startMusic=new Sound("/resources/Sounds/menu.wav");
        this.map = new Map("resources/map/map.png");
        this.gameOver = new Map("resources/caughtScreen/gotCaught.png");
        this.theEnd = new Map("resources/wonScreen/wonScreen.png");
        this.blockArray = new GameObject[167];
        this.movables = new Entity[5];
        this.doors = new Door[5];
        this.menuHandler = new MenuHandler(this);
    }

    public void init() {

        this.collisionDetector = new CollisionDetector();
        player = new Player(new MapPosition(2, 2,map), collisionDetector);
        player.getPosition().show();
        //collisionDetector.setPlayer(player);

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
                    blockArray[blockArrayIterator] = new Fence(new MapPosition(j , i, map));
                    blockArrayIterator++;
                }

                //WALL
                if (matrixPositions[i][j] == 2) {
                    blockArray[blockArrayIterator] = new Wall(new MapPosition(j, i, map));
                    blockArrayIterator++;
                }

                //DOOR
                if (matrixPositions[i][j] == 5) {
                    doors[doorArrayIterator] = new Door(new MapPosition(j, i, map),this.player);
                    doorArrayIterator++;
                }
            }
        }

        doors[2].shutDoor();
        doors[2].getPosition().setFacing(DirectionType.DOWN);
        doors[2].getPosition().show();

        collisionDetector = new CollisionDetector(this.player,this.blockArray,this.movables,this.doors);
        collisionDetector.setDoors(this.doors);


        player.setCollisionDetector(collisionDetector);
        player.setDoor(doors[2]);
        player.setBarrel(barrel);
        player.setKey(key);
    }

    public void moveAll() {

        barrel.move();

        player.checkWin();

        for (Entity object : movables) {
            object.move();
        }

        collisionDetector.lineOfSight(movables[0].getPosition(), movables[0].getPosition().getFacing());
        collisionDetector.lineOfSight(movables[1].getPosition(),movables[1].getPosition().getFacing());

        collisionDetector.verify();
    }

    public GameObject[] getBlockArray() {
        return blockArray;
    }

   public void timer() {
       for (int i = 5; i > 0; i--) {
           try {
               Thread.sleep(1000);
           }catch (InterruptedException e){
               e.printStackTrace();
           }
       }
   }

   public void restart() {

        this.player.getPosition().hide();
        this.player.setHasKey(false);
        this.player.setDetected(false);
        this.player.setWonLevel(false);

        this.barrel.getPosition().hide();
        this.key.getPosition().hide();

        for (Entity movable : movables){
            movable.getPosition().hide();
        }

        for (GameObject gameObject : blockArray) {
            gameObject.getPosition().hide();
        }

        for (Door door : doors) {
            door.getPosition().hide();
        }

        Route.resetAuxCounter();
        blockArrayIterator = 0;
        doorArrayIterator = 0;

        this.map.hide();
        this.gameOver.hide();
        this.theEnd.hide();
   }
}
