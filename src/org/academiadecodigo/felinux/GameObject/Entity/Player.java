package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.GameObject.DecorWall.Sound;
import org.academiadecodigo.felinux.GameObject.Item.Barrel;
import org.academiadecodigo.felinux.GameObject.Item.Door;
import org.academiadecodigo.felinux.GameObject.Item.Key;
import org.academiadecodigo.felinux.Position.*;
import org.academiadecodigo.felinux.Support.*;
import org.academiadecodigo.simplegraphics.keyboard.*;

public class Player extends Entity implements KeyboardHandler {

    private final int SPEED = 1;
    private Keyboard keyboard;
    private boolean detected;
    private boolean isHidden;
    private boolean hasKey;
    private boolean wonLevel;
    private CollisionDetector collisionDetector;
    private Barrel barrel;
    private boolean hasBarrel;
    private Key key;
    private Door door;
    private Sound hidingSound;

    public DirectionType currentDirection;

    public Player(MapPosition position,CollisionDetector collisionDetector) {
        super(position, GameObjectType.PLAYER);
        //action = false;
        detected = false;
        hasKey = false;
        wonLevel = false;
        keyboard = new Keyboard(this);
        this.collisionDetector = collisionDetector;
        hidingSound = new Sound("/resources/Sounds/hideSound.wav");

        this.init();
    }

    public boolean isDetected() {
        return detected;
    }

    public void gotDetected() {
        this.detected = true;
    }

    public void gotKey() {
        this.hasKey = true;
    }

    public boolean hasKey() {
        return this.hasKey;
    }

    public void gotBarrel() {
        this.hasBarrel = true;
    }

    public void dropBarrel() {
        System.out.println(hasBarrel);
        this.hasBarrel = false;
        this.barrel.drop();

    }

    public boolean hasWon() {
        return this.wonLevel;
    }

    public void init() {

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);
    }

    @Override
    public void move() {
        accelerate(currentDirection);
        super.move();
        if (this.door.getPosition().getCol() == getPosition().getCol() && this.door.getPosition().getRow() == getPosition().getRow()) {
            this.door.getPosition().setFacing(DirectionType.RIGHT);
        }
    }

    public void accelerate(DirectionType direction) {
        this.currentDirection = direction;
        getPosition().moveInDirection(direction, SPEED);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            //this.action = !action;
            spaceKeyUse();
            //System.out.println("nmmm"+this.action);
        }

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                currentDirection = DirectionType.UP;
                collisionDetector.barrelDropCheck();
                if (this.collisionDetector.isMovementAllowed(this.getPosition(),DirectionType.UP)
                        && this.collisionDetector.isDoorAhead(this.getPosition(),DirectionType.UP)
                        && !detected && !isHidden && getPosition().getCol() < 23) {

                    this.getPosition().moveInDirection(DirectionType.UP, 1);

                    if(hasBarrel){
                        barrel.getPosition().moveInDirection(DirectionType.UP,SPEED);
                    }
                    break;
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                collisionDetector.barrelDropCheck();
                currentDirection = DirectionType.RIGHT;
                if (this.collisionDetector.isMovementAllowed(this.getPosition(),DirectionType.RIGHT)
                        && this.collisionDetector.isDoorAhead(this.getPosition(),DirectionType.RIGHT)
                        && !detected && !isHidden && getPosition().getCol() < 23) {

                    this.getPosition().moveInDirection(DirectionType.RIGHT, 1);

                    if (hasBarrel) {
                        barrel.getPosition().moveInDirection(DirectionType.RIGHT,SPEED);
                    }
                    break;
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                collisionDetector.barrelDropCheck();
                currentDirection = DirectionType.DOWN;
                if (this.collisionDetector.isMovementAllowed(this.getPosition(),DirectionType.DOWN)
                        && this.collisionDetector.isDoorAhead(this.getPosition(),DirectionType.DOWN)
                        && !detected && !isHidden && getPosition().getCol() < 23) {

                    this.getPosition().moveInDirection(DirectionType.DOWN, 1);
                    if(hasBarrel) {
                        barrel.getPosition().moveInDirection(DirectionType.DOWN,SPEED);
                    }
                    break;
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                collisionDetector.barrelDropCheck();
                currentDirection = DirectionType.LEFT;
                if(this.collisionDetector.isMovementAllowed(this.getPosition(),DirectionType.LEFT)
                        && this.collisionDetector.isDoorAhead(this.getPosition(),DirectionType.LEFT)
                        && !detected && !isHidden && getPosition().getCol() < 23) {

                    this.getPosition().moveInDirection(DirectionType.LEFT, 1);
                    if(hasBarrel){
                        barrel.getPosition().moveInDirection(DirectionType.LEFT,SPEED);
                    }
                    break;
                }
                break;
        }
    }
    private void spaceKeyUse() {

       if (hasBarrel){
           isHidden=!isHidden;
           hidingSound.play(true);
           System.out.println("hiding :"+isHidden);
       }
       if(isHidden){
           this.getPosition().hide();
       }
       if(!isHidden){
           this.getPosition().show();
       }
        key.check();
        door.check();
        barrel.beenHold();
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    /*public boolean getAction() {
        return this.action;
    }*/

    /*public void setAction(boolean action) {
        this.action = action;
    }*/

    public boolean isHidden() {
        return isHidden;
    }

    public boolean hasBarrel(){
        return hasBarrel;
    }


    public void checkWin() {
        if (getPosition().getCol() == 23) {
            this.wonLevel = true;
            this.getPosition().hide();
        }
    }


    public void setBarrel(Barrel barrel) {
        this.barrel = barrel;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public void setDetected(boolean bool){
        this.detected = bool;
    }

    public void setWonLevel(boolean bool){
        this.wonLevel = bool;
    }

    public void setHasBarrel(boolean bool){
        this.hasBarrel = bool;
    }

    public void setHasKey(boolean bool){
        this.hasKey = false;
    }
}