package org.academiadecodigo.felinux.Position;

import org.academiadecodigo.felinux.GameObject.Entity.Guard;
import org.academiadecodigo.felinux.GameObject.Entity.Player;

public class Route {

    private static int auxCounter = 13;
    private static int move2count1 = 5;
    private static int move2count2 = 3;

    public static void guard1Move(Guard guard1) throws InterruptedException {


        if (guard1.getRectangle().getX() != 330 && auxCounter > 0){
            Thread.sleep(200);
            guard1.getRectangle().translate(- Map.CELL_SIZE, 0);
            auxCounter--;
        }

        if (guard1.getRectangle().getX() != 850 && auxCounter == 0){
            Thread.sleep(200);
            guard1.getRectangle().translate(Map.CELL_SIZE, 0);

            if (guard1.getRectangle().getX() == 850){
                auxCounter = 13;
            }
        }
    }

    public static void guard2Move(Guard guard2) throws InterruptedException {

       //RIGHT
       if(guard2.getRectangle().getX() != 290 && move2count1 != 0){
           Thread.sleep(200);
           guard2.getRectangle().translate(Map.CELL_SIZE, 0);
           move2count1--;
       }
       //DOWN
       if(guard2.getRectangle().getY() != 530 && move2count1 == 0){
           Thread.sleep(200);
           guard2.getRectangle().translate(0, Map.CELL_SIZE);
           move2count2--;
       }
       //LEFT
        if(guard2.getRectangle().getX() != 290 && move2count1 == 0){
            Thread.sleep(200);
            guard2.getRectangle().translate(-Map.CELL_SIZE,0);
        }
        //DOWN
        if(guard2.getRectangle().getY() != 610 && move2count2 == 0){
            Thread.sleep(200);
            guard2.getRectangle().translate(0, Map.CELL_SIZE);
        }
    }
}

