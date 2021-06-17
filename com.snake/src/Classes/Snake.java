package Classes;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import Engine.GameEngine;

public class Snake {
    private List<Rectangle> body;

    private int w = GameEngine.width;
    private int h = GameEngine.height;
    private int d = GameEngine.dimension;

    private String move;

    public Snake() {
        body = new ArrayList<>();

        Rectangle temp = new Rectangle(GameEngine.dimension, GameEngine.dimension);
        temp.setLocation(GameEngine.width / 2 * GameEngine.dimension, GameEngine.height / 2 * GameEngine.dimension);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 1) * d, (h / 2) * d);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 2) * d, (h / 2) * d);
        body.add(temp);

        move = "NOTHING";
    }

    public List<Rectangle> getBody() {
        return body;
    }

    public void setBody(List<Rectangle> body) {
        this.body = body;
    }

    public int getX() {
        return body.get(0).x;
    }

    public int getY() {
        return body.get(0).y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public void up() {
        move = "UP";
    }

    public void down() {
        move = "DOWN";
    }

    public void left() {
        move = "LEFT";
    }

    public void right() {
        move = "RIGHT";
    }

    public void move() {
        if (move != "NOTHING") {
            Rectangle first = body.get(0);
            Rectangle temp = new Rectangle(GameEngine.dimension, GameEngine.dimension);

            if (move == "UP") {
                temp.setLocation(first.x, first.y - GameEngine.dimension);
            } else if (move == "DOWN") {
                temp.setLocation(first.x, first.y + GameEngine.dimension);
            } else if (move == "LEFT") {
                temp.setLocation(first.x - GameEngine.dimension, first.y);
            } else {
                temp.setLocation(first.x + GameEngine.dimension, first.y);
            }

            body.add(0, temp);
            body.remove(body.size() - 1);
        }
    }

    public void growInSize() {
        Rectangle first = body.get(0);
        Rectangle temp = new Rectangle(GameEngine.dimension, GameEngine.dimension);
        if (move == "UP") {
            temp.setLocation(first.x, first.y - GameEngine.dimension);
        } else if (move == "DOWN") {
            temp.setLocation(first.x, first.y + GameEngine.dimension);

        } else if (move == "LEFT") {
            temp.setLocation(first.x - GameEngine.dimension, first.y);

        } else {
            temp.setLocation(first.x + GameEngine.dimension, first.y);

        }
        body.add(0, temp);

    }
}
