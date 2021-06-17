package Classes;

import java.awt.Rectangle;

import Engine.GameEngine;

public class Food {
    private int x;
    private int y;

    public Food(Snake player) {
        this.randSpawn(player);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void randSpawn(Snake player) {

        boolean onSnake = true;
        while (onSnake) {
            onSnake = false;
            for (Rectangle r : player.getBody()) {
                if (r.x == x && r.y == y) {
                    onSnake = true;

                }
            }
            x = (int) (Math.random() * GameEngine.width);
            y = (int) (Math.random() * GameEngine.height);
        }
    }
}
