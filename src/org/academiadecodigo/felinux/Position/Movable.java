package org.academiadecodigo.felinux.Position;

import org.academiadecodigo.felinux.Support.DirectionType;

public interface Movable {
    void setCollisionDetector(CollisionDetector collisionDetector);
    void move();
}
