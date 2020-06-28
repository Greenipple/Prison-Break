package org.academiadecodigo.felinux.Position;

import org.academiadecodigo.felinux.GameObject.Entity.Guard;
import org.academiadecodigo.felinux.Support.DirectionType;

public class Route {

    private static int auxCounter = 13;
    private static int move2count1 = 6;
    private static int move2count2 = 3;

    public static void guard1Move(Guard guard1) {


        if (guard1.getPosition().getCol() != 8 && auxCounter > 0){
            guard1.getPosition().moveInDirection(DirectionType.LEFT, 1);
            auxCounter--;
        }

        if (guard1.getPosition().getCol() != 21 && auxCounter == 0){
            guard1.getPosition().moveInDirection(DirectionType.RIGHT, 1);

            if (guard1.getPosition().getCol() == 21){
                auxCounter = 13;
            }
        }
    }

    public static void guard2Move(Guard guard2) {
        System.out.println("before conditions Rows " + guard2.getPosition().getRow());
        System.out.println("before conditions Cows " + guard2.getPosition().getCol());
       //RIGHT
       if(guard2.getPosition().getRow() == 10 && guard2.getPosition().getCol() != 7) {
           guard2.getPosition().moveInDirection(DirectionType.RIGHT, 1);
           return;

       }
        System.out.println("middle conditions Rows " + guard2.getPosition().getRow());
        System.out.println("middle conditions Cows " + guard2.getPosition().getCol());
       //DOWN
       if(guard2.getPosition().getCol() == 7 && guard2.getPosition().getRow() != 14) {
           guard2.getPosition().moveInDirection(DirectionType.DOWN, 1);
           return;
       }

/*       //LEFT
        if(guard2.getPosition().getRectangle().getX() != 290 && move2count1 == 0) {
            guard2.getPosition().getRectangle().translate(-Map.CELL_SIZE,0);
        }

        //DOWN
        if(guard2.getPosition().getRectangle().getY() != 610 && move2count2 == 0) {
            //Thread.sleep(200);
            guard2.getPosition().getRectangle().translate(0, Map.CELL_SIZE);
        }*/
    }
}

