package Tests;

import Chess.*;
import Piece.*;
import Piece.Piece;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckmateTest {
    Position start;
    Board board;
    Piece p_start;
    Player white;
    Player black;
    Game game;

    @Before
    public void setUp() {
        start = new Position(3,3);
        p_start = new King(start, Color.BLACK);
        board = new Board(8,8, p_start, start);
        this.board.setBlackKing(start);

        white = new Player(Color.WHITE);
        black = new Player(Color.BLACK);
        game = new Game(board, white, black);
    }

    @Test
    public void notInCheckmateRook() {
        board.board[3][3] = null;
        board.board[0][4] = new King(new Position(0,4), Color.BLACK);
        Piece rook1 = new Bishop(new Position(0,0), Color.BLACK);
        Piece rook2 = new Bishop(new Position(1,0), Color.BLACK);
        board.board[0][0] = rook1;
        board.board[1][0] = rook2;
        assertTrue(!game.isInCheckmate(board, Color.BLACK));
    }

    @Test
    public void inCheckBishop() {
        Piece bishop = new Bishop(new Position(5,5), Color.WHITE);
        board.board[5][5] = bishop;
        assertTrue(game.isInCheck(board, Color.BLACK));
    }

    @Test
    public void inCheckRook() {
        Piece rook = new Rook(new Position(5,3), Color.WHITE);
        board.board[5][3] = rook;
        assertTrue(game.isInCheck(board, Color.BLACK));
    }

    @Test
    public void inCheckQueenVertical() {
        Piece queen = new Queen(new Position(5,3), Color.WHITE);
        board.board[5][3] = queen;
        assertTrue(game.isInCheck(board, Color.BLACK));
        board.board[5][3] = null;
    }

    @Test
    public void inCheckQueenHorizontal() {
        Piece queen = new Queen(new Position(3, 5), Color.WHITE);
        board.board[3][5] = queen;
        assertTrue(game.isInCheck(board, Color.BLACK));
        board.board[3][5] = null;
    }

    @Test
    public void inCheckPawnDiagRightAttack() {
        Piece pawn = new Pawn(new Position(4, 2), Color.WHITE);
        board.board[4][2] = pawn;
        assertTrue(game.isInCheck(board, Color.BLACK));
    }

    @Test
    public void inCheckPawnDiagLeftAttack() {
        Piece pawn = new Pawn(new Position(4, 4), Color.WHITE);
        board.board[4][4] = pawn;
        assertTrue(game.isInCheck(board, Color.BLACK));
    }

}
