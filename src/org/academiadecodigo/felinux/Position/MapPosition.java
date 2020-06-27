package org.academiadecodigo.felinux.PrisonBreakGame.Position;

import org.academiadecodigo.felinux.PrisonBreakGame.Game;
import org.academiadecodigo.felinux.PrisonBreakGame.Support.DirectionType;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class MapPosition {

        private int col;
        private int row;
        private Map map;
        private Color color;
        private Game game;
        private DirectionType facing;


        public MapPosition(int col, int row, Map map,Game game) {
            this.col = col;
            this.row = row;
            this.map = map;
            this.game = game;
        }

        public void moveInDirection(DirectionType direction, int distance) {

            switch (direction) {

                case UP:
                    moveUp(distance);
                    //translate( - Map.CELL_SIZE,0);
                    break;
                case DOWN:
                    moveDown(distance);
                    break;
                case LEFT:
                    moveLeft(distance);
                    break;
                case RIGHT:
                    moveRight(distance);
                    break;
            }

        }

        public boolean equals(MapPosition pos) {
            return this.col == pos.getCol() && this.row == pos.getRow() ? true : false;
        }

        public void moveUp(int distance) {
            for (int j = 0; j < distance; j++) {
                boolean movementAllowed = true;
                for (int i = 0; i < game.getBlockArray().length; i++) {
                    if ((game.getBlockArray()[i].getPosition().col == col) && (game.getBlockArray()[i].getPosition().row == row - 1)) {
                        movementAllowed = false;
                        break;
                    }
                }
                    if (movementAllowed) {
                        facing=DirectionType.UP;
                        row--;
                    }

           /* int maxRowsUp = dist < getRow() ? dist : getRow();
            setPos(getCol(), getRow() - maxRowsUp);*/

            }
        }

        public void moveDown(int dist) {
            for (int j=0; j<dist; j++){
                boolean movementAllowed = true;
                for (int i=0; i< game.getBlockArray().length; i++){
                  if ((game.getBlockArray()[i].getPosition().col == col) && (game.getBlockArray()[i].getPosition().row == row+1)){
                      movementAllowed = false;
                      break;
                  }
                  if (movementAllowed){
                      facing = DirectionType.DOWN;
                      row++;
                  }
                }
            }

            /*int maxRowsDown = dist > getMap().ROWS - (getRow() + 1) ? getMap().ROWS - (getRow() + 1) : dist;
            setPos(getCol(), getRow() + maxRowsDown);*/
        }

        public void moveLeft(int dist) {
            for (int j=0; j<dist; j++){
                boolean movementAllowed = true;
                for (int i=0; i<game.getBlockArray().length; i++){
                    if ((game.getBlockArray()[i].getPosition().row == row) && (game.getBlockArray()[i].getPosition().col == col-1)){
                        movementAllowed = false;
                        break;
                    }
                    if (movementAllowed){
                        facing = DirectionType.LEFT;
                        col--;
                    }
                }
            }

          /*  int maxRowsLeft = dist < getCol() ? dist : getCol();
            setPos(getCol() - maxRowsLeft, getRow());*/

        }


        public void moveRight(int dist) {
            for (int j=0; j<dist; j++){
                boolean movementAllowed = true;
                for (int i=0; i<game.getBlockArray().length; i++){
                    if ((game.getBlockArray()[i].getPosition().row == row) && (game.getBlockArray()[i].getPosition().col == col+1)){
                        movementAllowed = false;
                        break;
                    }
                    if(movementAllowed){
                        facing = DirectionType.RIGHT;
                        col++;
                    }
                }
            }
           /* int maxRowsRight = dist > getMap().COLS - (getCol() + 1) ? getMap().COLS - (getCol() + 1) : dist;
            setPos(getCol() + maxRowsRight, getRow());*/
        }

        public Color getColor(){
            return this.color;
        }

        public void setColor(Color color){
            this.color = color;
        }

    public Map getMap() {
        return map;
    }

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
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