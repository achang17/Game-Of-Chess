package Piece;

import Chess.Color;
import Chess.Position;

public class King extends Piece {

    public King(Position pos, Color c) {
        super(pos, c);
    }

    @Override
    public Piece clone() {
        return new King(this.pos, this.color);
    }

    /**
     * @before Player specifies a potential move from Position curr to Position next.
     * @after Returns true if the move is valid for this specific piece, and this move will be made in the Player class.
     * @param board Reflects current state of the chessboard.
     * @param c Color of the player, used to distinguish which pieces this player can move.
     * @param curr Current position of the piece the player wants to move.
     * @param next Next position the player wants to move the piece to.
     */
    @Override
    public boolean isValidMove(Piece[][] board, Color c, Position curr, Position next) {
        Piece pieceAtNext = board[next.row][next.col];

        if (next.isOutOfBounds(board.length, board[0].length)) return false;
        if (board[curr.row][curr.col].color != c) return false;

        if (curr.row == next.row && curr.col == next.col+1) {
            return checkMove(pieceAtNext, c);
        } else if (curr.row == next.row && curr.col == next.col-1) {
            return checkMove(pieceAtNext, c);
        } else if (curr.row == next.row-1 && curr.col == next.col+1) {
            return checkMove(pieceAtNext, c);
        } else if (curr.row == next.row-1 && curr.col == next.col) {
            return checkMove(pieceAtNext, c);
        } else if (curr.row == next.row-1 && curr.col == next.col-1) {
            return checkMove(pieceAtNext, c);
        } else if (curr.row == next.row+1 && curr.col == next.col+1) {
            return checkMove(pieceAtNext, c);
        } else if (curr.row == next.row+1 && curr.col == next.col) {
            return checkMove(pieceAtNext, c);
        } else if (curr.row == next.row+1 && curr.col == next.col-1) {
            return checkMove(pieceAtNext, c);
        }

        return false;
    }


}
