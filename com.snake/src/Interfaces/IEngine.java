package Interfaces;

public interface IEngine {
    public static final int width = 30;
    public static final int height = 30;
    public static final int dimension = 20;

    public abstract void start();

    public abstract void update();

    public abstract boolean wallCollision();

    public abstract boolean foodCollision();

    public abstract boolean playerCollision();

}
