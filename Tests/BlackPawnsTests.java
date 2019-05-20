package Tests;

import Chess.*;
import Piece.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlackPawnsTests {
    Position start;
    Board board;
    Piece p_start;
    Player player;

    @Before
    public void setUp() {
        start = new Position(1,3);
        p_start = new Pawn(start, Color.BLACK);
        board = new Board(8,8, p_start, start);
        player = new Player(Color.BLACK);
    }

    @Test
    public void testSetUp() {
        assertEquals(board.board[1][3], p_start);
    }

    @Test
    public void BlackStraightMove() throws InvalidMoveException {
        Position end = new Position(2,3);
        player.makeMove(board, Color.BLACK, start, end);
        assertEquals(board.board[2][3], p_start);
    }

    @Test(expected = InvalidMoveException.class)
    public void BlackStraightMoveWithPieceInWay() throws InvalidMoveException {
        Piece blockPiece = new Pawn(new Position(2,3), Color.BLACK);
        board.board[2][3] = blockPiece;

        Position end = new Position(2,3);
        player.makeMove(board, Color.BLACK, start, end);
    }

    @Test
    public void BlackAheadTwoMove() throws InvalidMoveException {
        Position end = new Position(3,3);
        player.makeMove(board, Color.BLACK, start, end);
        assertEquals(board.board[3][3], p_start);
    }

    @Test(expected = InvalidMoveException.class)
    public void BlackAheadTwoMoveWithPieceInWay() throws InvalidMoveException {
        Piece blockPiece = new Pawn(new Position(2,3), Color.WHITE);
        board.board[2][3] = blockPiece;

        Position end = new Position(3,3);
        player.makeMove(board, Color.BLACK, start, end);
    }


    @Test(expected = InvalidMoveException.class)
    public void BlackAheadTwoMoveWithPieceInSpot() throws InvalidMoveException {
        Piece blockPiece = new Pawn(new Position(3,3), Color.WHITE);
        board.board[3][3] = blockPiece;

        Position end = new Position(3,3);
        player.makeMove(board, Color.BLACK, start, end);
    }

    @Test
    public void BlackDiagMove() throws InvalidMoveException {
        Piece blockPiece = new Pawn(new Position(2,2), Color.WHITE);
        board.board[2][2] = blockPiece;

        Position end = new Position(2,2);
        player.makeMove(board, Color.BLACK, start, end);
        assertEquals(board.board[2][2], p_start);
    }

    @Test(expected = InvalidMoveException.class)
    public void BlackDiagMoveOwnPieceInSpot() throws InvalidMoveException {
        Piece blockPiece = new Pawn(new Position(2,2), Color.BLACK);
        board.board[2][2] = blockPiece;

        Position end = new Position(2,2);
        player.makeMove(board, Color.BLACK, start, end);
    }
    
    @Test(expected = InvalidMoveException.class)
    public void BlackDiagMoveInvalid() throws InvalidMoveException {
        Position end = new Position(2,2);
        player.makeMove(board, Color.BLACK, start, end);
    }

    @Test(expected = InvalidMoveException.class)
    public void invalidBlackOutOfBoundsMove() throws InvalidMoveException {
        start = new Position(6,3);
        p_start.pos = start;
        board.board[6][3] = p_start;

        Position end = new Position(8,3);
        player.makeMove(board, Color.BLACK, start, end);
    }


}
