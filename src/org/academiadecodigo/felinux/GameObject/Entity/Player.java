package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.GameObject.Item.Barrel;
import org.academiadecodigo.felinux.Position.*;
import org.academiadecodigo.felinux.Support.*;
import org.academiadecodigo.simplegraphics.keyboard.*;

public class Player extends Entity implements KeyboardHandler {

    private final int SPEED = 1;
    private boolean startGame;
    private Keyboard keyboard;
    private boolean action;
    private boolean detected;
    private boolean isHidden;
    private boolean key;
    private boolean wonLevel;
    private CollisionDetector collisionDetector;
    private Barrel barrel;
    private boolean hasBarrel;

    public DirectionType currentDirection;

    public Player(MapPosition position,CollisionDetector collisionDetector) {
        super(position, GameObjectType.PLAYER);
        action = false;
        detected = false;
        key = false;
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
        this.key = true;
    }

    public boolean hasKey() {
        return this.key;
    }

    public void gotBarrel() {
        this.hasBarrel = true;
    }

    public void dropBarrel(){
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

        KeyboardEvent sKey = new KeyboardEvent();
        sKey.setKey(KeyboardEvent.KEY_S);
        sKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(sKey);

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

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            //this.action = !action;
            this.startGame = true;
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

                    if(hasBarrel){
                        barrel.getPosition().moveInDirection(DirectionType.RIGHT,SPEED);
                    }
                    break;
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                collisionDetector.barrelDropCheck();
                currentDirection = DirectionType.DOWN;
                if(this.collisionDetector.isMovementAllowed(this.getPosition(),DirectionType.DOWN)
                        && this.collisionDetector.isDoorAhead(this.getPosition(),DirectionType.DOWN)
                        && !detected && !isHidden && getPosition().getCol() < 23) {
                    this.getPosition().moveInDirection(DirectionType.DOWN, 1);

                    if(hasBarrel){
                        barrel.getPosition().moveInDirection(DirectionType.DOWN,SPEED);
                    }
                    break;
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                collisionDetector.barrelDropCheck();
                if(this.collisionDetector.isMovementAllowed(this.getPosition(),DirectionType.LEFT)
                        && this.collisionDetector.isDoorAhead(this.getPosition(),DirectionType.LEFT)
                        && !detected && !isHidden && getPosition().getCol() < 23) {
                    currentDirection = DirectionType.LEFT;
                    this.getPosition().moveInDirection(DirectionType.LEFT, 1);

                    if(hasBarrel){
                        barrel.getPosition().moveInDirection(DirectionType.LEFT,SPEED);
                    }
                    break;
                }
                break;
        }
    }
    private void spaceKeyUse(){

       if (hasBarrel){
           isHidden=!isHidden;
           System.out.println("hiding :"+isHidden);
       }
       if(isHidden){
           this.getPosition().hide();
       }
       if(!isHidden){
           this.getPosition().show();
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

    public boolean hasBarrel(){
        return hasBarrel;
    }


    public void checkWin() {
        if (getPosition().getCol() == 23) {
            this.wonLevel = true;
        }
    }


    public void setBarrel(Barrel barrel) {
        this.barrel = barrel;
    }

    public boolean getStartGame(){
        return startGame;
    }
}