import javax.swing.*;
public class App {

    public static void main(String[] args) throws Exception {
        int boardWith = 600;
        int boardHeight = boardWith;

        JFrame frame = new JFrame("Snake Game");
        frame.setVisible(true);
        frame.setSize(boardWith, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGame snakeGame = new SnakeGame(boardWith, boardHeight);
        frame.add(snakeGame);
        frame.pack();
        snakeGame.requestFocus();

    }
}
