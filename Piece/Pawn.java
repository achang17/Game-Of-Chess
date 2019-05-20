package Piece;

import Chess.Color;
import Chess.Position;

public class Pawn extends Piece {

    public Pawn(Position pos, Color c) {
        super(pos, c);
    }

    @Override
    public Piece clone() {
        return new Pawn(this.pos, this.color);

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
        if (next.isOutOfBounds(board.length, board[0].length)) return false;
        if (board[curr.row][curr.col].color != c) return false;

        Piece pieceAtNext = board[next.row][next.col];

        if (c == Color.BLACK) {
            if (curr.row == 1 && next.col == curr.col) {
                if (next.row == 2) {
                    return board[next.row][next.col] == null && checkMove(pieceAtNext, c);
                } else if (next.row == 3) {
                    return board[2][next.col] == null && board[next.row][next.col] == null && checkMove(pieceAtNext, c);
                }
            } else if (next.row == curr.row+1 && next.col == curr.col) {
                return board[next.row][next.col] == null && checkMove(pieceAtNext, c);
            } else if (next.row == curr.row+1 && next.col == curr.col-1) {
                return board[next.row][next.col] != null && checkMove(pieceAtNext, c);
            } else if (next.row == curr.row+1 && next.col == curr.col+1) {
                return board[next.row][next.col] != null && checkMove(pieceAtNext, c);
            }
        } else {
            if (curr.row == 6 && next.col == curr.col) {
                if (next.row == 5) {
                    return board[next.row][next.col] == null && checkMove(pieceAtNext, c);
                } else if (next.row == 4) {
                    return board[5][next.col] == null && board[next.row][next.col] == null && checkMove(pieceAtNext, c);
                }
            } else if (next.row == curr.row-1 && next.col == curr.col) {
                return board[next.row][next.col] == null && checkMove(pieceAtNext, c);
            } else if (next.row == curr.row-1 && next.col == curr.col-1) {
                return board[next.row][next.col] != null && checkMove(pieceAtNext, c);
            } else if (next.row == curr.row-1 && next.col == curr.col+1) {
                return board[next.row][next.col] != null && checkMove(pieceAtNext, c);
            }
        }

        return false;
    }

}
