package org.academiadecodigo.felinux;

import org.academiadecodigo.felinux.Position.Map;
import org.academiadecodigo.felinux.Support.DirectionType;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.felinux.Position.MapPosition;

public class GameKbHandler implements KeyboardHandler {

    private Rectangle rectangle;
    private MapPosition mapPosition;

    public GameKbHandler(Rectangle rectangle, MapPosition mapPosition) {
        this.rectangle = rectangle;
        this.mapPosition = mapPosition;
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                //rectangle.translate( - Map.CELL_SIZE,0);
                mapPosition.moveInDirection(DirectionType.LEFT, 1);
                break;
            case KeyboardEvent.KEY_RIGHT:
                //rectangle.translate(Map.CELL_SIZE , 0);
                mapPosition.moveInDirection(DirectionType.RIGHT, 1);
                break;
            case KeyboardEvent.KEY_UP:
                //rectangle.translate(0, -Map.CELL_SIZE);
                mapPosition.moveInDirection(DirectionType.UP, 1);
                break;
            case KeyboardEvent.KEY_DOWN:
                //rectangle.translate(0, Map.CELL_SIZE);
                mapPosition.moveInDirection(DirectionType.DOWN, 1);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }

}
