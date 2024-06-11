import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    private class Tile {
        int x;
        int y;
        Tile(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int boardWidth;
    int boardHeight;
    int tileSize = 25;
    Tile snakeHead;
    Random random;
    Tile food;


    // Game logic

    Timer gameLoop;
    int velocityX;
    int velocitiY;


    SnakeGame(int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);

        snakeHead = new Tile(5,5);

        food = new Tile(10,10);

        random = new Random();

        placeFood();

        gameLoop = new Timer(100, this);
        gameLoop.start();

        velocitiY = 0;
        velocityX = 0;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        //
        for (int i = 0; i < boardWidth/tileSize; i++) {
            // (x1,y1,x2,y2)
            g.drawLine(i * tileSize,0,i*tileSize,boardHeight);
            g.drawLine(0, i*tileSize,boardWidth,i*tileSize);
        }


        //Food
        g.setColor(Color.red);
        g.fillRect(food.x * tileSize, food.y * tileSize, tileSize, tileSize);

        //Snake
        g.setColor(Color.green);
        g.fillRect(snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize);
    }

    public void placeFood() {
        food.x = random.nextInt(boardWidth / tileSize); // 600 / 25 -> 24
        food.y = random.nextInt(boardHeight/ tileSize); // 600 / 25 -> 24
    }

    public void move() {
        snakeHead.x += velocityX;
        snakeHead.y += velocitiY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() ==  KeyEvent.VK_UP){
            velocityX = 0;
            velocitiY = -1;
        }
        else if(e.getKeyCode() ==  KeyEvent.VK_DOWN){
            velocityX = 0;
            velocitiY = 1;
        }
        else if(e.getKeyCode() ==  KeyEvent.VK_RIGHT){
            velocityX = 1;
            velocitiY = 0;
        }
        else if(e.getKeyCode() ==  KeyEvent.VK_LEFT){
            velocityX = -1;
            velocitiY = 0;
        }
    }

}
