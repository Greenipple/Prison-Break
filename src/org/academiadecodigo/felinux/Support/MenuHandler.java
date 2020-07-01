package org.academiadecodigo.felinux.Support;

import org.academiadecodigo.felinux.Game;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MenuHandler implements KeyboardHandler {

    private Keyboard keyboard;
    private Game game;
    private boolean startGame;

    public MenuHandler(Game game) {
        this.keyboard = new Keyboard(this);
        this.game = game;
        this.startGame = false;
    }

    public void init() {
        KeyboardEvent sKey = new KeyboardEvent();
        sKey.setKey(KeyboardEvent.KEY_S);
        sKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(sKey);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            //this.action = !action;
            this.startGame = true;
            //System.out.println("nmmm"+this.action);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public boolean isStartGame() {
        return this.startGame;
    }
}
