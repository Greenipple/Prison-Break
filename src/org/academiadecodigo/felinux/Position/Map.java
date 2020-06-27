package org.academiadecodigo.felinux.Position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Map {

    public static final int CELL_SIZE = 50;
    public static final int PADDING = 10;
    public static final int COLS = 24;
    public static final int ROWS = 18;
    private Rectangle rect;

    public Map(){

    }

    public void init() {

        rect = new Rectangle(PADDING, PADDING, mapWidth(), mapHeight());
        rect.setColor(Color.WHITE);
        rect.draw();

    }


/*<<<<<<< HEAD
=======

>>>>>>> 06c288726460187a03d19c28d1fb8cfd2617e9fb*/
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
