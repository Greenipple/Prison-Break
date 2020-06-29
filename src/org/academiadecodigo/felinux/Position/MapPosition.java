package org.academiadecodigo.felinux.Position;

import org.academiadecodigo.felinux.Support.DirectionType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MapPosition {

        private int col;
        private int row;
        private Map map;
        private Color color;
        private java.lang.String source;
        private DirectionType facing;
        private Rectangle rectangle;
        private Picture picture;

        public MapPosition(int col, int row, Map map) {
            this.col = col;
            this.row = row;
            this.map = map;
            this.rectangle = new Rectangle(this.col * Map.CELL_SIZE + Map.PADDING, this.row * Map.CELL_SIZE + Map.PADDING, Map.CELL_SIZE, Map.CELL_SIZE);
            //this.picture = new Picture(this.col * Map.CELL_SIZE + Map.PADDING, this.row * Map.CELL_SIZE + Map.PADDING, "");
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
            //this.picture.translate(moveCol,moveRow);
        }

        public boolean equals(MapPosition pos) {
            return this.col == pos.getCol() && this.row == pos.getRow() ? true : false;
        }
        //movement is not allowed if block (blockArray) is not present in front.
        public void moveUp(int distance) {
            for (int i=0; i<distance; i++){
                row--;
            }

        }

        public void moveDown(int distance) {
            for (int i = 0; i < distance; i++) {
                row++;
            }
        }

        public void moveLeft(int distance) {

            for (int i = 0; i < distance; i++) {
                col--;
            }
        }

        public void moveRight(int distance) {

            for (int i = 0; i < distance; i++) {
                col++;
            }
        }

        public Color getColor(){
            return this.color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
        /*
        public void setSource(java.lang.String source) {
            this.picture.load(source);
        }*/

        public void setPosition(int col, int row) {
            int previousCol = this.col;
            int previousRow = this.row;

            this.col = col;
            this.row = row;

            int moveCol = (this.col - previousCol)*Map.CELL_SIZE;
            int moveRow = (this.row - previousRow)*Map.CELL_SIZE;
            this.rectangle.translate(moveCol,moveRow);
            //this.picture.translate(moveCol,moveRow);
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

            //this.picture.load(this.source);
            //this.picture.draw();
    }

    public void hide() {
        this.rectangle.delete();
        //this.picture.delete();
    }

}