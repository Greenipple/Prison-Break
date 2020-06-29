package org.academiadecodigo.felinux.Support;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum GameObjectType {
    FENCE(Color.DARK_GRAY,""),
    WALL(Color.BLACK,"resources/Wall/wall.png"),
    BARREL(Color.GRAY,"Barrel.png"),
    KEY(Color.YELLOW,""),
    DOOR(Color.LIGHT_GRAY,"door close.png"),
    GUARD(Color.BLUE,"blackPoliceFront.png"),
    DOG(Color.RED,"DogUp.png"),
    PLAYER(Color.GREEN,"CowboyFront.png");

    private Color color;
    private java.lang.String source;

    GameObjectType(Color color, java.lang.String source) {
        this.color = color;
        this.source = source;
    }

    public Color getColor() {
        return this.color;
    }

    public java.lang.String getSource() {
        return this.source;
    }
}
