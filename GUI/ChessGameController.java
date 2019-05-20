package GUI;

import Chess.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChessGameController implements ActionListener {
    static ChessGameView view;

    static Game game;
    static Board gameboard;
    static Player currPlayer;

    static Position currPos;
    static Position moveToPos;

    static boolean isMakingMove;

    public ChessGameController(ChessGameView view) {
        this.view = view;
        initView();
        view.addNewGameMenuListener(this);
        view.addRestartMenuListener(this);

        game = new Game();
        gameboard = game.board;
        currPlayer = new Player(Color.BLACK);
    }

    /**
     * This function takes care of reading in clicked positions on the board. It is called by a MouseListener and will
     * wait for two positions to be clicked before calling the function makeMove().
     * @param row
     * @param col
     */
    public static void takePos(int row, int col) {
        if (!isMakingMove && gameboard.board[row][col] != null) {
            isMakingMove = true;
            currPos = new Position(row, col);
        } else if (isMakingMove){
            moveToPos = new Position(row, col);
            makeMove();
        }
    }

    /**
     * This function takes care of validating a move, and making the move if it is valid. It takes care of toggling the
     * turns between players, and also checking for end game conditions (i.e. Checkmate).
     */
    private static void makeMove() {
        try {
            if (game.isInCheckmate(gameboard, Color.WHITE)) {
                System.out.println("CHECKMATE WHITE!");
            }
            if (game.isInCheckmate(gameboard, Color.BLACK)) {
                System.out.println("CHECKMATE BLACK!");
            }

            currPlayer.makeMove(gameboard, currPlayer.color, currPos, moveToPos);
            String icon = view.board.squares[currPos.row][currPos.col].iconPath;
            view.board.squares[moveToPos.row][moveToPos.col].fillPiece(icon);
            view.board.squares[currPos.row][currPos.col].emptySquare();

            if (movedBlackKing()) {
                gameboard.blackKing = moveToPos;
            }

            if (movedWhiteKing()) {
                gameboard.whiteKing = moveToPos;
            }

            togglePlayer();

        } catch (InvalidMoveException e) {
            System.out.println("Invalid move!");
            currPos = null;
            moveToPos = null;
            isMakingMove = false;
        }

        isMakingMove = false;
        currPos = null;
        moveToPos = null;
    }

    /**
     * This function determines if the Black King is moved, and updates the position of the black king accordingly. This
     * function helps the checkmate validations and is called in makeMove().
     * @return true if the Black King was moved.
     */
    private static boolean movedBlackKing() {
        if(currPos.row == gameboard.blackKing.row) {
            if (currPos.col == gameboard.blackKing.col) {
                return true;
            }
        }
        return false;
    }

    /**
     * This function determines if the White King is moved, and updates the position of the black king accordingly. This
     * function helps the checkmate validations and is called in makeMove().
     * @return true if the White King was moved.
     */
    private static boolean movedWhiteKing() {
        if(currPos.row == gameboard.whiteKing.row) {
            if (currPos.col == gameboard.whiteKing.col) {
                return true;
            }
        }
        return false;
    }

    /**
     * This function toggles the currPlayer between Black and White player after each move.
     */
    private static void togglePlayer() {
        if (currPlayer.color == Color.BLACK) {
            currPlayer.color = Color.WHITE;
        } else {
            currPlayer.color = Color.BLACK;
        }
    }

    public void initView() {
        view.drawPreGameLook();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Start New Game") {
            view.drawDefaultGame();
        } else if (e.getActionCommand() == "Restart") {
            gameboard = new Board(8,8);
            currPlayer = new Player(Color.BLACK);
            view.restartGameBoard();
        }
    }
}
