package org.academiadecodigo.felinux.Position;

import org.academiadecodigo.simplegraphics.graphics.*;

public class Map {

    public static final int CELL_SIZE = 40;
    public static final int PADDING = 10;
    public static final int COLS = 24;
    public static final int ROWS = 18;
    private Rectangle rect;

    public Map(){
        rect = new Rectangle(PADDING, PADDING, mapWidth(), mapHeight());
        rect.setColor(Color.WHITE);
        rect.draw();
    }

    /** auxiliary methods**/

    public int mapWidth(){
        return COLS * CELL_SIZE;
    }

    public int mapHeight(){
        return ROWS * CELL_SIZE;
    }

    public Rectangle getRect(){
        return this.rect;
    }
}
