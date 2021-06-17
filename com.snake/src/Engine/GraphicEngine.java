package Engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import Classes.Food;
import Classes.Snake;

public class GraphicEngine extends JPanel implements ActionListener {
    private Timer timer = new Timer(100, this);
    public String state;

    private Snake snake;
    private Food food;
    private GameEngine game;

    public GraphicEngine(GameEngine gameEngine) {
        timer.start();
        state = "START";
        game = gameEngine;
        snake = gameEngine.getPlayer();
        food = gameEngine.getFood();
        this.addKeyListener(game);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, GameEngine.width * GameEngine.dimension + 5, GameEngine.height * GameEngine.dimension + 5);

        if (state == "START") {

            String url1 = "src/Resources";
            ImageIcon imageIcon1 = new ImageIcon(url1);

            g.drawImage(imageIcon1.getImage(), 100, 200, this);
        } else if (state == "RUNNING") {
            g2d.setColor(Color.red);
            g2d.fillRect(food.getX() * GameEngine.dimension, food.getY() * GameEngine.dimension, GameEngine.dimension,
                    GameEngine.dimension);

            g2d.setColor(Color.CYAN);
            for (Rectangle r : snake.getBody()) {
                g2d.fill(r);
            }
        } else {
            g2d.setColor(Color.white);
            g2d.drawString("Your Score: " + (snake.getBody().size() - 3),
                    GameEngine.width / 2 * GameEngine.dimension - 40,
                    GameEngine.height / 2 * GameEngine.dimension - 20);
            String url2 = "src/Resources";
            ImageIcon imageIcon2 = new ImageIcon(url2);

            g.drawImage(imageIcon2.getImage(), 100, 200, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        game.update();

    }

}
