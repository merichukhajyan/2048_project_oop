import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameFrame extends JFrame implements ActionListener {
    private final ForLoops forLoops;
    private final JLabel scoreDisplay;
    private final JLabel highestScore;
    private final JButton newGame;
    Game game = new Game();

    public GameFrame() {

        super("2048 Board Game");

        game.generateNewTiles();
        game.generateNewTiles();

        forLoops = new ForLoops(game.getGameBoard().getBoard(), 30, 10);
        scoreDisplay = new JLabel("Score: 0");
        highestScore = new JLabel("Highest Score: 0");

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
                    game.moveUp();
                    scoreDisplay.setText("Score: " + Game.score);
                    highestScore.setText("Highest Score: " + Game.highestScore);
                    forLoops.repaint();
                    if (game.gameWon()) {
                        new WinScreen();
                        game.newGame();
                        forLoops.repaint();
                    } else if (game.gameLost()) {
                        new LoseScreen();
                        game.newGame();
                        forLoops.repaint();
                    }
                } else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                    game.moveDown();
                    scoreDisplay.setText("Score: " + Game.score);
                    highestScore.setText("Highest Score: " + Game.highestScore);
                    forLoops.repaint();
                    if (game.gameWon()) {
                        new WinScreen();
                        game.newGame();
                        forLoops.repaint();
                    } else if (game.gameLost()) {
                        new LoseScreen();
                        game.newGame();
                        forLoops.repaint();
                    }

                } else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                    game.moveLeft();
                    scoreDisplay.setText("Score: " + Game.score);
                    highestScore.setText("Highest Score: " + Game.highestScore);
                    forLoops.repaint();
                    if (game.gameWon()) {
                        new WinScreen();
                        game.newGame();
                        forLoops.repaint();
                    } else if (game.gameLost()) {
                        new LoseScreen();
                        game.newGame();
                        forLoops.repaint();
                    }

                } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                    game.moveRight();
                    scoreDisplay.setText("Score: " + Game.score);
                    highestScore.setText("Highest Score: " + Game.highestScore);
                    forLoops.repaint();
                    if (game.gameWon()) {
                        new WinScreen();
                        game.newGame();
                        forLoops.repaint();
                    } else if (game.gameLost()) {
                        new LoseScreen();
                        game.newGame();
                        forLoops.repaint();
                    }

                } else if (key == KeyEvent.VK_N) {
                    game.newGame();
                    forLoops.repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        newGame = new JButton("New Game");
        newGame.setBounds(780, 270, 250, 60);
        newGame.addActionListener(this);
        newGame.setFocusable(false);
        ImageIcon newGameIcon = new ImageIcon(new ImageIcon("Images/new_game_controller.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        newGame.setIcon(newGameIcon);
        newGame.setBackground(new Color(123, 50, 250));
        newGame.setFont(new Font("Times New Roman", Font.BOLD, 30));


        scoreDisplay.setBackground(new Color(156, 138, 114));
        scoreDisplay.setOpaque(true);
        scoreDisplay.setForeground(Color.WHITE);
        scoreDisplay.setFont(new Font("Times New Roman", Font.BOLD, 25));
        ImageIcon scoreImage = new ImageIcon(new ImageIcon("Images/star.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        scoreDisplay.setIcon(scoreImage);
        scoreDisplay.setVerticalAlignment(JLabel.CENTER);// scoreDisplay position within its borders
        scoreDisplay.setHorizontalAlignment(JLabel.CENTER);
        scoreDisplay.setBounds(700, 30, 330, 40);


        highestScore.setBackground(new Color(156, 138, 114)); // The color of Score's background
        highestScore.setOpaque(true);
        highestScore.setForeground(Color.WHITE);
        highestScore.setFont(new Font("Times New Roman", Font.BOLD, 25));
        ImageIcon highestScoreImage = new ImageIcon(new ImageIcon(
                "Images/star_highest_score.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        highestScore.setIcon(highestScoreImage);
        highestScore.setHorizontalAlignment(JLabel.CENTER);
        highestScore.setBounds(700, 150, 330, 40);

        forLoops.setBounds(0, 0, 700, 700);

        setResizable(false);
        add(highestScore);
        add(scoreDisplay);
        add(forLoops);
        add(newGame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1050, 750);
        setLayout(null); // to be able to set the borders of scoreDisplay layout by myself
        setLocationRelativeTo(null); // Opens the window in the middle of the screen
        ImageIcon titleImage = new ImageIcon("Images/logo.png");
        setIconImage(titleImage.getImage());
        getContentPane().setBackground(new Color(250, 218, 221));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.newGame();
        forLoops.repaint();

    }
}