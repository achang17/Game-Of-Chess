package Chess;

import Piece.*;

import static org.junit.Assert.assertEquals;

public class Player {
    public Color color;

    public Player(Color color) {
        this.color = color;
    }
    /**
     * @param c The color of the current player making a move
     * This function will check take in a specified piece and check whether it can make the specified move.
     * This will be edited for a GUI implementation by listening for clicked positions
     */
    public void makeMove(Board board, Color c, Position curr, Position next) throws InvalidMoveException {
        Piece[][] myBoard = board.board;

        if (myBoard[curr.row][curr.col].isValidMove(myBoard, c, curr, next)) {
            myBoard[curr.row][curr.col].setPos(next);
            Piece temp = myBoard[curr.row][curr.col];
            myBoard[curr.row][curr.col] = null;
            myBoard[next.row][next.col] = temp;

        } else {
            throw new InvalidMoveException("This is an invalid move!");
        }
    }
}
