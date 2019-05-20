package Tests;

import Chess.*;
import Piece.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WhitePawnsTests {
    Position start;
    Board board;
    Piece p_start;
    Player player;

    @Before
    public void setUp() {
        start = new Position(6,3);
        p_start = new Pawn(start, Color.WHITE);
        board = new Board(8,8, p_start, start);
        player = new Player(Color.WHITE);
    }

    @Test
    public void testSetUp() {
        assertEquals(board.board[6][3], p_start);
    }

    @Test
    public void WhiteStraightMove() throws InvalidMoveException {
        Position end = new Position(5,3);
        player.makeMove(board, Color.WHITE, start, end);
        assertEquals(board.board[5][3], p_start);
    }

    @Test(expected = InvalidMoveException.class)
    public void WhiteStraightMoveWithPieceInWay() throws InvalidMoveException {
        Piece blockPiece = new Pawn(new Position(5,3), Color.WHITE);
        board.board[5][3] = blockPiece;

        Position end = new Position(4,3);
        player.makeMove(board, Color.WHITE, start, end);
    }

    @Test
    public void WhiteAheadTwoMove() throws InvalidMoveException {
        Position end = new Position(4,3);
        player.makeMove(board, Color.WHITE, start, end);
        assertEquals(board.board[4][3], p_start);
    }

    @Test(expected = InvalidMoveException.class)
    public void WhiteAheadTwoMoveWithPieceInWay() throws InvalidMoveException {
        Piece blockPiece = new Pawn(new Position(5,3), Color.WHITE);
        board.board[5][3] = blockPiece;

        Position end = new Position(4,3);
        player.makeMove(board, Color.WHITE, start, end);
    }


    @Test(expected = InvalidMoveException.class)
    public void WhiteAheadTwoMoveWithPieceInSpot() throws InvalidMoveException {
        Piece blockPiece = new Pawn(new Position(4,3), Color.BLACK);
        board.board[4][3] = blockPiece;

        Position end = new Position(4,3);
        player.makeMove(board, Color.WHITE, start, end);
    }

    @Test
    public void WhiteDiagMove() throws InvalidMoveException {
        Piece blockPiece = new Pawn(new Position(5,2), Color.BLACK);
        board.board[5][2] = blockPiece;

        Position end = new Position(5,2);
        player.makeMove(board, Color.WHITE, start, end);
        assertEquals(board.board[5][2], p_start);
    }

    @Test(expected = InvalidMoveException.class)
    public void WhiteDiagMoveOwnPieceInSpot() throws InvalidMoveException {
        Piece blockPiece = new Pawn(new Position(2,2), Color.WHITE);
        board.board[5][2] = blockPiece;

        Position end = new Position(5,2);
        player.makeMove(board, Color.WHITE, start, end);
    }

    @Test(expected = InvalidMoveException.class)
    public void WhiteDiagMoveInvalid() throws InvalidMoveException {
        Position end = new Position(5,2);
        player.makeMove(board, Color.BLACK, start, end);
    }
}
