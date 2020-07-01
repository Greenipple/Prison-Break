package org.academiadecodigo.felinux.GameObject.Entity;

import org.academiadecodigo.felinux.Position.*;
import org.academiadecodigo.felinux.Support.GameObjectType;

public class Guard extends Entity {

    private int route;

    public Guard(MapPosition position, int route) {
        super(position, GameObjectType.GUARD);
        this.route = route;
    }

    @Override
    public void move() {

        if (route == 1) {
            Route.guard1Move(this);
            return;
        }
        Route.guard2Move(this);

        super.move();
    }
}