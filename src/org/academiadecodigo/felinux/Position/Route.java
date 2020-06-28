package org.academiadecodigo.felinux.Position;

import org.academiadecodigo.felinux.GameObject.Entity.Guard;

public class Route {

    private static int auxCounter = 13;
    private static int move2count1 = 5;
    private static int move2count2 = 3;

    public static void guard1Move(Guard guard1) {


        if (guard1.getPosition().getRectangle().getX() != 330 && auxCounter > 0){
            //Thread.sleep(200);
            guard1.getPosition().getRectangle().translate(- Map.CELL_SIZE, 0);
            auxCounter--;
        }

        if (guard1.getPosition().getRectangle().getX() != 850 && auxCounter == 0){
            //Thread.sleep(200);
            guard1.getPosition().getRectangle().translate(Map.CELL_SIZE, 0);

            if (guard1.getPosition().getRectangle().getX() == 850){
                auxCounter = 13;
            }
        }
    }

    public static void guard2Move(Guard guard2) {

       //RIGHT
       if(guard2.getPosition().getRectangle().getX() != 290 && move2count1 != 0) {
           //Thread.sleep(200);
           guard2.getPosition().getRectangle().translate(Map.CELL_SIZE, 0);
           move2count1--;
       }
       //DOWN
       if(guard2.getPosition().getRectangle().getY() != 530 && move2count1 == 0) {
           //Thread.sleep(200);
           guard2.getPosition().getRectangle().translate(0, Map.CELL_SIZE);
           move2count2--;
       }
       //LEFT
        if(guard2.getPosition().getRectangle().getX() != 290 && move2count1 == 0) {
            //Thread.sleep(200);
            guard2.getPosition().getRectangle().translate(-Map.CELL_SIZE,0);
        }
        //DOWN
        if(guard2.getPosition().getRectangle().getY() != 610 && move2count2 == 0) {
            //Thread.sleep(200);
            guard2.getPosition().getRectangle().translate(0, Map.CELL_SIZE);
        }
    }
}

