package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.Position.*;
import org.academiadecodigo.felinux.Support.*;
import org.academiadecodigo.simplegraphics.keyboard.*;

public class Player extends Entity implements KeyboardHandler {

    private final int SPEED = 1;
    private Keyboard keyboard;
    private boolean action;
    private boolean detected;
    private boolean hasKey;
    private boolean isHidden;
    private boolean wonLevel;
    private CollisionDetector collisionDetector;

    private boolean hasBarrel;

    public DirectionType currentDirection;

    public Player(MapPosition position,CollisionDetector collisionDetector) {
        super(position, GameObjectType.PLAYER);
        action = false;
        detected = false;
        hasKey = false;
        wonLevel = false;
        keyboard = new Keyboard(this);
        this.collisionDetector = collisionDetector;

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

    public void gotBarrel() {
        this.hasBarrel = true;
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
                if (this.collisionDetector.isMovementAllowed(this.getPosition(),DirectionType.UP) && !detected && !isHidden){
                    this.getPosition().moveInDirection(DirectionType.UP, 1);
                    break;
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                currentDirection = DirectionType.RIGHT;
                if (this.collisionDetector.isMovementAllowed(this.getPosition(),DirectionType.RIGHT) && !detected && !isHidden){
                    this.getPosition().moveInDirection(DirectionType.RIGHT, 1);
                    break;
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                currentDirection = DirectionType.DOWN;
                if(this.collisionDetector.isMovementAllowed(this.getPosition(),DirectionType.DOWN) && !detected && !isHidden) {
                    this.getPosition().moveInDirection(DirectionType.DOWN, 1);
                    break;
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if(this.collisionDetector.isMovementAllowed(this.getPosition(),DirectionType.LEFT) && !detected && !isHidden) {
                    currentDirection = DirectionType.LEFT;
                    this.getPosition().moveInDirection(DirectionType.LEFT, 1);
                    break;
                }
                break;
        }
    }
    private void spaceKeyUse(){

       if (hasBarrel){
           isHidden=!isHidden;
           System.out.println(isHidden);
       }

        this.action=!action;

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public boolean getAction() {
        return this.action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public boolean isHidden() {
        return isHidden;
    }


}