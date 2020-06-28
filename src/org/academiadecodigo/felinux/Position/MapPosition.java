package org.academiadecodigo.felinux.Position;

import org.academiadecodigo.felinux.Game;
import org.academiadecodigo.felinux.Support.DirectionType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class MapPosition {

        private int col;
        private int row;
        private Map map;
        private Color color;
        private DirectionType facing;
        private Rectangle rectangle;

        public MapPosition(int col, int row, Map map) {
            this.col = col;
            this.row = row;
            this.map = map;
            this.rectangle = new Rectangle(this.col * Map.CELL_SIZE + Map.PADDING, this.row * Map.CELL_SIZE + Map.PADDING, Map.CELL_SIZE, Map.CELL_SIZE);
        }

        public void moveInDirection(DirectionType direction, int distance) {

            int previousCol = this.col;
            int previousRow = this.row;

            switch (direction) {

                case UP:
                    moveUp(distance);
                    facing = DirectionType.UP;
                    break;
                case DOWN:
                    moveDown(distance);
                    facing = DirectionType.DOWN;
                    break;
                case LEFT:
                    moveLeft(distance);
                    facing = DirectionType.LEFT;
                    break;
                case RIGHT:
                    moveRight(distance);
                    facing = DirectionType.RIGHT;
                    break;
            }

            int moveCol = (this.col - previousCol)*Map.CELL_SIZE;
            int moveRow = (this.row - previousRow)*Map.CELL_SIZE;
            this.rectangle.translate(moveCol,moveRow);
        }

        public boolean equals(MapPosition pos) {
            return this.col == pos.getCol() && this.row == pos.getRow() ? true : false;
        }
        //movement is not allowed if block (blockArray) is not present in front.
        public void moveUp(int distance) {
            row--;
/*            for (int i = 0; i < distance; i++) {
                this.row -= Map.CELL_SIZE;
            }*/

            /*for (int j = 0; j < distance; j++) {
                boolean movementAllowed = true;
                for (int i = 0; i < game.getBlockArray().length; i++) {
                    if ((game.getBlockArray()[i].getPosition().col == col) && (game.getBlockArray()[i].getPosition().row == row - 1)) {
                        movementAllowed = false;
                        break;
                    }
                }
                    if (movementAllowed) {
                       // facing=DirectionType.UP;
                        this.row -= Map.CELL_SIZE;
                    }

           int maxRowsUp = dist < getRow() ? dist : getRow();
            setPos(getCol(), getRow() - maxRowsUp);

            }*/
        }

        public void moveDown(int distance) {

            for (int i = 0; i < distance; i++) {
                row++;
            }
            /*
            for (int j=0; j<distance; j++){
                boolean movementAllowed = true;
                for (int i=0; i< game.getBlockArray().length; i++){
                  if ((game.getBlockArray()[i].getPosition().col == col) && (game.getBlockArray()[i].getPosition().row == row+1)){
                      movementAllowed = false;
                      break;
                  }
                  if (movementAllowed){
                     // facing = DirectionType.DOWN;
                      this.row += Map.CELL_SIZE;
                  }
                }
            }

            int maxRowsDown = distance > getMap().ROWS - (getRow() + 1) ? getMap().ROWS - (getRow() + 1) : distance;
            setPos(getCol(), getRow() + maxRowsDown);*/
        }

        public void moveLeft(int distance) {

            for (int i = 0; i < distance; i++) {
                col--;
            }

            /*
            for (int j=0; j<distance; j++){
                boolean movementAllowed = true;
                for (int i=0; i<game.getBlockArray().length; i++){
                    if ((game.getBlockArray()[i].getPosition().row == row) && (game.getBlockArray()[i].getPosition().col == col-1)){
                        movementAllowed = false;
                        break;
                    }
                    if (movementAllowed){
                       // facing = DirectionType.LEFT;
                        this.col -= Map.CELL_SIZE;
                    }
                }
            }

            int maxRowsLeft = distance < getCol() ? distance : getCol();
            setPos(getCol() - maxRowsLeft, getRow());*/

        }

        public void moveRight(int distance) {

            for (int i = 0; i < distance; i++) {
                col++;
            }

            /*
            for (int j=0; j<distance; j++){
                boolean movementAllowed = true;
                for (int i=0; i<game.getBlockArray().length; i++){
                    if ((game.getBlockArray()[i].getPosition().row == row) && (game.getBlockArray()[i].getPosition().col == col+1)){
                        movementAllowed = false;
                        break;
                    }
                    if(movementAllowed){
                       // facing = DirectionType.RIGHT;
                        this.col += Map.CELL_SIZE;
                    }
                }
            }
            int maxRowsRight = distance > getMap().COLS - (getCol() + 1) ? getMap().COLS - (getCol() + 1) : distance;
            setPos(getCol() + maxRowsRight, getRow());*/
        }

        public Color getColor(){
            return this.color;
        }

        public void setColor(Color color){
            this.color = color;
        }

    public void setPosition(int col, int row) {
            this.rectangle.delete();
            this.col = col;
            this.row = row;
            this.rectangle.fill();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Rectangle getRectangle(){
        return this.rectangle;
    }

    public void show() {
            this.rectangle.setColor(this.color);
            this.rectangle.fill();
    }

    public void hide() {
        this.rectangle.delete();
    }

/*
    public void movesGuard1() { //posiçao inicial  do guard1  (4.21)
        while (!player.isDetected()) {
            while (guard1.row != 8) {
                guard1.translate(moveLeft(Map.CELL_SIZE));
            }
            while (guard1.row != 21) {
                guard1.translate(moveRight(Map.CELL_SIZE));
                //if (getdetected = true) {
                //  break;
                //}
            }
        }
    }

        public void movesGuard2 () { // posiçao inicial do guard2 (10.2)
            while (!player.isDetected()) {
                while (guard2.col >= 2 && guard2.col != 7) {
                    guard2.translate(moveRight(Map.CELL_SIZE));
                }
                while (guard2.row >= 10 && guard2.row != 15) {
                    guard2.translate(moveDown(Map.CELL_SIZE));
                }
                while (guard2.col >= 7 && guard2.col != 2) {
                    guard2.translate(moveRight(Map.CELL_SIZE));
                }


            }
        }
*/

    }