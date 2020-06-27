package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.Game;
import org.academiadecodigo.felinux.GameKbHandler;
import org.academiadecodigo.felinux.Position.*;
import org.academiadecodigo.felinux.Support.*;
import org.academiadecodigo.simplegraphics.keyboard.*;

import java.awt.*;

public class Player extends Entity implements KeyboardHandler {

    private final int SPEED = 1;
    private Keyboard keyboard;
    private boolean action;
    private boolean detected;


    public CollisionDetector collisionDetector;
    public DirectionType currentDirection;
    public KeyboardHandler kbHandler = new GameKbHandler(getRectangle());

    public Player(MapPosition position, Map map) {
        super(position, GameObjectType.PLAYER, map);
        action = false;
        detected = false;
        keyboard = new Keyboard(kbHandler);
        init();
    }

    public boolean isDetected() {
        return detected;
    }

    public void gotDetected() {
        this.detected = true;
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
            action = true;
        }

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                currentDirection = DirectionType.UP;
                break;
            case KeyboardEvent.KEY_RIGHT:
                currentDirection = DirectionType.RIGHT;
                break;
            case KeyboardEvent.KEY_DOWN:
                currentDirection = DirectionType.DOWN;
                break;
            case KeyboardEvent.KEY_LEFT:
                currentDirection = DirectionType.LEFT;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            action = false;
        }
    }
}