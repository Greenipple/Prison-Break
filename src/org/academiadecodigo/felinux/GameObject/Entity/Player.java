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
    private CollisionDetector collisionDetector;


    public DirectionType currentDirection;

    public Player(MapPosition position,CollisionDetector collisionDetector) {
        super(position, GameObjectType.PLAYER);
        action = false;
        detected = false;
        hasKey = false;
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
            this.action = !action;
            System.out.println(""+this.action);
        }

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                currentDirection = DirectionType.UP;
                if (this.collisionDetector.isMovementAllowed(this.getPosition(),DirectionType.UP)){
                    this.getPosition().moveInDirection(DirectionType.UP, 1);
                    break;
                }
            case KeyboardEvent.KEY_RIGHT:
                currentDirection = DirectionType.RIGHT;
                if (this.collisionDetector.isMovementAllowed(this.getPosition(),DirectionType.RIGHT)){
                    this.getPosition().moveInDirection(DirectionType.RIGHT, 1);
                    break;
                }
            case KeyboardEvent.KEY_DOWN:
                currentDirection = DirectionType.DOWN;
                if(this.collisionDetector.isMovementAllowed(this.getPosition(),DirectionType.DOWN)) {
                    this.getPosition().moveInDirection(DirectionType.DOWN, 1);
                    break;
                }
            case KeyboardEvent.KEY_LEFT:
                if(this.collisionDetector.isMovementAllowed(this.getPosition(),DirectionType.LEFT)) {
                    currentDirection = DirectionType.LEFT;
                    this.getPosition().moveInDirection(DirectionType.LEFT, 1);
                    break;
                }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        /*if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            this.action = false;
        }*/
    }

    public boolean getAction() {
        return this.action;
    }
}