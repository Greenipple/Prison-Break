package org.academiadecodigo.felinux.Position;

import org.academiadecodigo.felinux.GameObject.Entity.Guard;
import org.academiadecodigo.felinux.GameObject.Entity.Player;

public class Route {

    private static int auxCounter = 13;

    public static void guard1Move(Guard guard1) throws InterruptedException {


        System.out.println(guard1.getRectangle().getX());
            if (guard1.getRectangle().getX() != 330 && auxCounter > 0){
                System.out.println(guard1.getRectangle().getX());
                Thread.sleep(200);
                guard1.getRectangle().translate(- Map.CELL_SIZE, 0);
                auxCounter--;
            }

        if (guard1.getRectangle().getX() != 850 && auxCounter == 0){
            System.out.println(guard1.getRectangle().getX());
            Thread.sleep(200);
            guard1.getRectangle().translate(Map.CELL_SIZE, 0);

            if (guard1.getRectangle().getX() == 850){
                auxCounter = 13;
            }
        }
            //MoveRight
/*            while (guard1.getPosition().getCol() != (9 * Map.CELL_SIZE)){
                Thread.sleep(500);
                //guard1.getPosition().setPos(guard1.getPosition().getCol() + 1, guard1.getPosition().getRow());
                guard1.getRectangle().translate(- Map.CELL_SIZE, 0);

            }*/
            //MoveLeft
    /*        while (guard1.getPosition().getCol() != (21 * Map.CELL_SIZE)) {
                Thread.sleep(500);
                //guard1.getPosition().setPos(guard1.getPosition().getCol() - 1, guard1.getPosition().getRow());
                guard1.getRectangle().translate(Map.CELL_SIZE, 0);
            }*/
    }
}

