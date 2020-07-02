package org.academiadecodigo.felinux.Support;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum GameObjectType {
    FENCE(Color.DARK_GRAY, "resources/Wall/wall.png", "resources/Wall/wall.png", "resources/Wall/wall.png", "resources/Wall/wall.png"),
    WALL(Color.BLACK, "resources/Wall/wall.png", "resources/Wall/wall.png", "resources/Wall/wall.png", "resources/Wall/wall.png"),
    BARREL(Color.GRAY, "resources/Barrel/Barrel.png", "resources/Barrel/Barrel.png", "resources/Barrel/Barrel.png", "resources/Barrel/Barrel.png"),
    KEY(Color.YELLOW, "resources/key/key.png", "resources/key/key.png", "resources/key/key.png", "resources/key/key.png"),
    DOOR(Color.LIGHT_GRAY, "resources/door/ironDoorClose.png", "resources/door/ironDoorClose.png", "resources/door/ironDoorClose.png", "resources/door/ironDoorClose.png"),
    GUARD(Color.BLUE, "resources/Police/BlackPolice/blackPoliceBack.png", "resources/Police/BlackPolice/blackPoliceRight.png", "resources/Police/BlackPolice/blackPoliceFront.png", "resources/Police/BlackPolice/blackPoliceLeft.png"),
    DOG(Color.RED, "resources/Dog/DogUp.png", "resources/Dog/DogRight.png", "resources/Dog/DogDown.png", "resources/Dog/DogLeft.png"),
    PLAYER(Color.GREEN, "resources/player/CowboyPlayer/CowboyFront.png", "resources/player/CowboyPlayer/CowboyRight.png", "resources/player/CowboyPlayer/CowboyBack.png", "resources/player/CowboyPlayer/CowBoyLeft.png");

    private Color color;
    private String sourceUp;
    private String sourceRight;
    private String sourceDown;
    private String sourceLeft;

    GameObjectType(Color color, String sourceUp, String sourceRight, String sourceDown, String sourceLeft) {
        this.color = color;
        this.sourceUp = sourceUp;
        this.sourceRight = sourceRight;
        this.sourceDown = sourceDown;
        this.sourceLeft = sourceLeft;
    }

    public Color getColor() {
        return this.color;
    }

    public String getSource(DirectionType direction) {
        switch (direction) {
            case UP: return this.sourceUp;
            case RIGHT: return this.sourceRight;
            case DOWN: return this.sourceDown;
            default: return this.sourceLeft;
        }
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
