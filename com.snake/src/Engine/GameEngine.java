package Engine;

import Interfaces.IEngine;
import javax.swing.JFrame;
import Classes.Food;
import Classes.Snake;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameEngine implements KeyListener, IEngine {

    private Snake player;
    private Food food;
    private GraphicEngine graphicEngine;
    private JFrame window;

    public GameEngine() {

        window = new JFrame();

        player = new Snake();

        food = new Food(player);

        graphicEngine = new GraphicEngine(this);

        window.add(graphicEngine);

        window.setTitle("La Serpiente Reticulona");
        window.setSize(width * dimension + 2, height * dimension + dimension + 4);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Snake getPlayer() {
        return player;
    }

    public void setPlayer(Snake player) {
        this.player = player;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public GraphicEngine getGraphicEngine() {
        return graphicEngine;
    }

    public void setGraphicEngine(GraphicEngine graphicEngine) {
        this.graphicEngine = graphicEngine;
    }

    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    @Override
    public void start() {
        graphicEngine.state = "RUNNING";

    }

    @Override
    public void update() {
        if (graphicEngine.state == "RUNNING") {
            if (foodCollision()) {
                player.growInSize();
                food.randSpawn(player);
            } else if (wallCollision() || playerCollision()) {
                graphicEngine.state = "END";
            } else {
                player.move();
            }
        }

    }

    @Override
    public boolean wallCollision() {
        if (player.getX() < 0 || player.getX() >= width * dimension || player.getY() < 0
                || player.getY() >= height * dimension) {
            return true;
        }
        return false;

    }

    @Override
    public boolean foodCollision() {
        if (player.getX() == food.getX() * dimension && player.getY() == food.getY() * dimension) {
            return true;
        }
        return false;

    }

    @Override
    public boolean playerCollision() {
        for (int i = 1; i < player.getBody().size(); i++) {
            if (player.getX() == player.getBody().get(i).x && player.getY() == player.getBody().get(i).y) {
                return true;
            }
        }
        return false;

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (graphicEngine.state == "RUNNING") {
            if (keyCode == KeyEvent.VK_W && player.getMove() != "DOWN") {
                player.up();
            }

            if (keyCode == KeyEvent.VK_S && player.getMove() != "UP") {
                player.down();
            }

            if (keyCode == KeyEvent.VK_A && player.getMove() != "RIGHT") {
                player.left();
            }

            if (keyCode == KeyEvent.VK_D && player.getMove() != "LEFT") {
                player.right();
            }
        } else {
            this.start();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
