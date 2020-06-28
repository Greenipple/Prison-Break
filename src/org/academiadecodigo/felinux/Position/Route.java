package org.academiadecodigo.felinux.Position;

import org.academiadecodigo.felinux.GameObject.Entity.Guard;
import org.academiadecodigo.felinux.Support.DirectionType;

public class Route {

    private static int auxCounter = 13;
    private static int path = 15;

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

       if (path > 0) {

           //RIGHT
           if (guard2.getPosition().getRow() == 10 && guard2.getPosition().getCol() != 7) {
               guard2.getPosition().moveInDirection(DirectionType.RIGHT, 1);
               path--;
               return;
           }

           //DOWN
           if (guard2.getPosition().getCol() == 7 && guard2.getPosition().getRow() != 14) {
               guard2.getPosition().moveInDirection(DirectionType.DOWN, 1);
               path--;
               return;
           }

           //LEFT
           if (guard2.getPosition().getRow() == 14 && guard2.getPosition().getCol() != 2) {
               guard2.getPosition().moveInDirection(DirectionType.LEFT, 1);
               path--;
               return;
           }

           //DOWN
           if (guard2.getPosition().getCol() == 2 && guard2.getPosition().getRow() != 15) {
               guard2.getPosition().moveInDirection(DirectionType.DOWN, 1);
               path--;
               return;
           }
       }

        /*******************************************************************************/

        if(path == 0) {

            //RESET
            if (guard2.getPosition().getRow() == 10 && guard2.getPosition().getCol() == 2){
                path = 15;
                return;
            }

            //UP
            if (guard2.getPosition().getCol() == 2 && guard2.getPosition().getRow() != 14) {
                guard2.getPosition().moveInDirection(DirectionType.UP, 1);
                return;
            }

            //RIGHT
            if (guard2.getPosition().getRow() == 14 && guard2.getPosition().getCol() != 7) {
                guard2.getPosition().moveInDirection(DirectionType.RIGHT, 1);
                return;
            }

            //UP
            if (guard2.getPosition().getCol() == 7 && guard2.getPosition().getRow() != 10) {
                guard2.getPosition().moveInDirection(DirectionType.UP, 1);
                return;
            }

            //LEFT
            if (guard2.getPosition().getRow() == 10 && guard2.getPosition().getCol() != 2) {
                guard2.getPosition().moveInDirection(DirectionType.LEFT, 1);
                return;
            }
        }
    }
}

