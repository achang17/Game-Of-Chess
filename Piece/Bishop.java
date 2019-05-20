package Piece;

import Chess.Color;
import Chess.Position;

public class Bishop extends Piece{

    public Bishop(Position pos, Color c) {
        super(pos, c);
    }

    @Override
    public Piece clone() {
        return new Bishop(this.pos, this.color);
    }


    @Override
    public boolean isValidMove(Piece[][] board, Color color, Position curr, Position next) {
        return isBishopMove(board, color, curr, next);
    }
}

