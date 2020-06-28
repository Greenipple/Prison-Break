package org.academiadecodigo.felinux.Support;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum GameObjectType {
    FENCE(Color.DARK_GRAY),
    WALL(Color.BLACK),
    BARREL(Color.GRAY),
    KEY(Color.YELLOW),
    DOOR(Color.LIGHT_GRAY),
    GUARD(Color.BLUE),
    DOG(Color.RED),
    PLAYER(Color.GREEN);

    private Color color;

    GameObjectType(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}
