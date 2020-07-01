package org.academiadecodigo.felinux.Support;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum GameObjectType {
    FENCE(Color.DARK_GRAY,"resources/Wall/wall.png"),
    WALL(Color.BLACK,"resources/Wall/wall.png"),
    BARREL(Color.GRAY,"resources/Barrel/Barrel.png"),
    KEY(Color.YELLOW,"resources/Dog/DogUp.png"),
    DOOR(Color.LIGHT_GRAY,"resources/door/door close.png"),
    GUARD(Color.BLUE,"resources/Police/BlackPolice/blackPoliceFront.png"),
    DOG(Color.RED,"resources/Dog/DogUp.png"),
    PLAYER(Color.GREEN,"resources/player/CowboyPlayer/CowboyFront.png");

    private Color color;
    private String sourceUp;
    private String sourceRight;
    private String sourceDown;
    private String sourceLeft;

    GameObjectType(Color color, String sourceUp) {
        this.color = color;
        this.sourceUp = sourceUp;
    }

    public Color getColor() {
        return this.color;
    }

    public String getSourceUp() {
        return this.sourceUp;
    }

    public String getSourceRight() {
        return this.sourceRight;
    }

    public String getSourceDown() {
        return this.sourceDown;
    }

    public String getSourceLeft() {
        return this.sourceLeft;
    }
}
