package Tests;

import Chess.*;
import Piece.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RooksTests {
    Position start;
    Board board;
    Piece p_start;
    Player player;

    @Before
    public void setUp() {
        start = new Position(3,3);
        p_start = new Rook(start, Color.BLACK);
        board = new Board(8,8, p_start, start);
        player = new Player(Color.BLACK);
    }

    @Test
    public void testSetUp() {
        assertEquals(board.board[3][3], p_start);
    }

    @Test
    public void testValidMoveQuadrant1Horizontal() throws InvalidMoveException {
        Position end = new Position(3,7);
        player.makeMove(board, Color.BLACK, start, end);
        assertEquals(board.board[3][7], p_start);
    }

    @Test
    public void testValidMoveQuadrant1Vertical() throws InvalidMoveException {
        Position end = new Position(0,3);
        player.makeMove(board, Color.BLACK, start, end);
        assertEquals(board.board[0][3], p_start);
    }

    @Test
    public void testValidMoveQuadrant2Horizontal() throws InvalidMoveException {
        Position end = new Position(3,0);
        player.makeMove(board, Color.BLACK, start, end);
        assertEquals(board.board[3][0], p_start);
    }

}
