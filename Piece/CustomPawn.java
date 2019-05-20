package Piece;

import Chess.Color;
import Chess.Position;

public class CustomPawn extends Piece {

    public CustomPawn(Position pos, Color c) {
        super(pos, c);
    }

    @Override
    public Piece clone() {
        return new CustomPawn(this.pos, this.color);
    }

    /**
     * @before Player specifies a potential move from Position curr to Position next.
     * @after Returns true if the move is valid for this specific piece, and this move will be made in the Player class.
     * @param board Reflects current state of the chessboard.
     * @param color Color of the player, used to distinguish which pieces this player can move.
     * @param curr Current position of the piece the player wants to move.
     * @param next Next position the player wants to move the piece to.
     */
    @Override
    public boolean isValidMove(Piece[][] board, Color color, Position curr, Position next) {
        if (next.isOutOfBounds(board.length, board[0].length)) return false;

        Piece pieceAtNext = board[next.row][next.col];

        if (color == Color.BLACK) {
            if (next.row == curr.row+2 && next.col == curr.col) {
                return board[next.row+1][next.col] == null && checkMove(pieceAtNext, color);
            } else if (next.row == curr.row+1 && next.col == curr.col) {
                return board[next.row][next.col] == null && checkMove(pieceAtNext, color);
            } else if (next.row == curr.row+1 && next.col == curr.col-1) {
                return board[next.row][next.col] != null && checkMove(pieceAtNext, color);
            } else if (next.row == curr.row+1 && next.col == curr.col+1) {
                return board[next.row][next.col] != null && checkMove(pieceAtNext, color);
            }
        } else {
            if (next.row == curr.row-2 && next.col == curr.col) {
                return board[next.row-1][next.col] == null && checkMove(pieceAtNext, color);
            } else if (next.row == curr.row-1 && next.col == curr.col) {
                return board[next.row][next.col] == null && checkMove(pieceAtNext, color);
            } else if (next.row == curr.row-1 && next.col == curr.col-1) {
                return board[next.row][next.col] != null && checkMove(pieceAtNext, color);
            } else if (next.row == curr.row-1 && next.col == curr.col+1) {
                return board[next.row][next.col] != null && checkMove(pieceAtNext, color);
            }
        }

        return false;
    }

}
