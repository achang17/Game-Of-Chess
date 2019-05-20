package Tests;

import Chess.*;
import Piece.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BishopTests {
    Position start;
    Board board;
    Piece p_start;
    Player player;

    @Before
    public void setUp() {
        start = new Position(3,3);
        p_start = new Bishop(start, Color.BLACK);
        board = new Board(8,8, p_start, start);
        player = new Player(Color.BLACK);
    }

    @Test
    public void testSetUp() {
        assertEquals(board.board[3][3], p_start);
    }

    @Test
    public void testValidMoveQuadrant1() throws InvalidMoveException {
        Position end = new Position(5,5);
        player.makeMove(board, Color.BLACK, start, end);
        assertEquals(board.board[5][5], p_start);
    }

    @Test
    public void testValidMoveQuadrant2() throws InvalidMoveException {
        Position end = new Position(1,1);
        player.makeMove(board, Color.BLACK, start, end);
        assertEquals(board.board[1][1], p_start);
    }

    @Test
    public void testValidMoveQuadrant3() throws InvalidMoveException {
        Position end = new Position(1,5);
        player.makeMove(board, Color.BLACK, start, end);
        assertEquals(board.board[1][5], p_start);
    }

    @Test
    public void testValidMoveQuadrant4() throws InvalidMoveException {
        Position end = new Position(6,6);
        player.makeMove(board, Color.BLACK, start, end);
        assertEquals(board.board[6][6], p_start);
    }

    @Test (expected = Chess.InvalidMoveException.class)
    public void invalidMoveQuadrant1() throws InvalidMoveException {
        Position end = new Position(6, 7);
        player.makeMove(board, Color.BLACK, start, end);
    }

    @Test (expected = Chess.InvalidMoveException.class)
    public void invalidMoveQuadrant2() throws InvalidMoveException {
        Position end = new Position(1, 2);
        player.makeMove(board, Color.BLACK, start, end);
    }

    @Test (expected = Chess.InvalidMoveException.class)
    public void invalidMoveQuadrant3() throws InvalidMoveException {
        Position end = new Position(1, 7);
        player.makeMove(board, Color.BLACK, start, end);
    }

    @Test (expected = Chess.InvalidMoveException.class)
    public void invalidMoveQuadrant4() throws InvalidMoveException {
        Position end = new Position(5, 7);
        player.makeMove(board, Color.BLACK, start, end);
    }
}
