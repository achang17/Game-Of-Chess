package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChessGameView extends JPanel {
    private JFrame chessframe;
    private JPanel chessboardPanel;
    public ChessBoard board;

    private JMenu gameMenu;
    public JMenuItem newGameMenuItem;
    public JMenuItem forfeitMenuItem;
    public JMenuItem restartMenuItem;

    public ChessGameView() {
        chessframe = new JFrame("Chess Game");
    }

    /**
     * This function initializes the JFrame upon opening the GUI.
     */
    private void initChessFrame() {
        chessframe.setLayout(new BorderLayout());
        chessframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chessframe.setSize(1200, 750);
        chessframe.setLocationRelativeTo(null);
        chessframe.setVisible(true);
    }

    /**
     * This initializes the visuals when we open the GUI, but before we start a game. This draws the chessboard without
     * any pieces.
     */
    public void drawPreGameLook() {
        initChessFrame();
        board = new ChessBoard(8,8);

        chessframe.getContentPane().setLayout(new FlowLayout());

        JPanel whitePlayerPanel = new JPanel();
        whitePlayerPanel.setPreferredSize(new Dimension(100,750));
        JLabel whitePlayerLabel = new JLabel("White Player");
        whitePlayerPanel.add(whitePlayerLabel);
        JTextArea whiteScore = new JTextArea("0");
        whitePlayerPanel.add(whiteScore);
        chessframe.add(whitePlayerPanel);

        JPanel blackPlayerPanel = new JPanel();
        JLabel blackPlayerLabel = new JLabel("Black Player");
        blackPlayerPanel.setPreferredSize(new Dimension(100,750));
        blackPlayerPanel.add(blackPlayerLabel);
        JTextArea blackScore = new JTextArea("0");
        blackPlayerPanel.add(blackScore);

        chessframe.add(blackPlayerPanel);

        chessboardPanel = new JPanel();
        chessboardPanel.setPreferredSize(new Dimension(800,800));
        chessboardPanel.add(board);
        chessframe.add(chessboardPanel);

        JMenuBar menu = new JMenuBar();
        gameMenu = new JMenu("Game");
        newGameMenuItem = new JMenuItem("Start New Game");
        forfeitMenuItem = new JMenuItem("Forfeit");
        restartMenuItem = new JMenuItem("Restart");

        gameMenu.add(newGameMenuItem);
        gameMenu.add(forfeitMenuItem);
        gameMenu.add(restartMenuItem);

        menu.add(gameMenu);

        chessframe.setJMenuBar(menu);
        chessframe.setVisible(true);
    }

    /**
     * This function is called when a player selects "Start New Game" from JMenuBar.
     */
    public void drawDefaultGame() {
        System.out.println("Entered drawDefaultGame in ChessGameView class");
        board.drawChessBoardWithPieces();
        chessframe.add(chessboardPanel);
        chessframe.setVisible(true);
        revalidate();
    }

    /**
     * This function is called when the user selects "Restart" from the JMenuBar. This will reset the chessboard, the
     * game, and move pieces to starting positions.
     */
    public void restartGameBoard() {
        System.out.println("in restart");
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board.squares[row][col].emptySquare();
            }
        }
        revalidate();
        repaint();
        drawDefaultGame();
        revalidate();

    }

    public void addNewGameMenuListener(ActionListener a) {
        newGameMenuItem.addActionListener(a);
    }
    public void addRestartMenuListener(ActionListener a) {
        restartMenuItem.addActionListener(a);
    }

}