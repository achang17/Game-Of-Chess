package Piece;

import Chess.Color;
import Chess.Position;

public class Queen extends Piece{

    public Queen(Position pos, Color c) {
        super(pos, c);
    }

    @Override
    public Piece clone() {
        return new Queen(this.pos, this.color);
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

        return isRookMove(board, c, curr, next) || isBishopMove(board, c, curr, next);
    }



}
