package org.academiadecodigo.felinux.Position;

import org.academiadecodigo.felinux.GameObject.Entity.Guard;
import org.academiadecodigo.felinux.GameObject.Entity.Player;

public class Route {


    public static void guard1Move(Guard guard1) {

            //MoveRight
            while (guard1.getPosition().getRow() != 8) {

                //guard1.getPosition().setPos(guard1.getPosition().getCol() + 1, guard1.getPosition().getRow());
                guard1.getRectangle().translate(0, 1);

            }
            //MoveLeft
            while (guard1.getPosition().getRow() != 21) {

                //guard1.getPosition().setPos(guard1.getPosition().getCol() - 1, guard1.getPosition().getRow());
                guard1.getRectangle().translate(0, -1);
            }
        }
    }

