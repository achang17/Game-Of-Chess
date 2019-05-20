package Tests;

import Chess.*;
import Piece.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomWhitePawnTests {
    Position start;
    Board board;
    Piece p_start;
    Player player;

    @Before
    public void setUp() {
        start = new Position(5,3);
        p_start = new CustomPawn(start, Color.WHITE);
        board = new Board(8,8, p_start, start);
        player = new Player(Color.WHITE);
    }

    @Test
    public void testSetUp() {
        assertEquals(board.board[5][3], p_start);
    }

    @Test
    public void WhiteStraightMove() throws InvalidMoveException {
        Position end = new Position(4,3);
        player.makeMove(board, Color.WHITE, start, end);
        assertEquals(board.board[4][3], p_start);
    }

    @Test
    public void WhiteAheadTwoMove() throws InvalidMoveException {
        Position end = new Position(3,3);
        player.makeMove(board, Color.WHITE, start, end);
        assertEquals(board.board[3][3], p_start);
    }

    @Test(expected = InvalidMoveException.class)
    public void invalidWhiteAheadThreeMove() throws InvalidMoveException {
        Position end = new Position(2,3);
        player.makeMove(board, Color.WHITE, start, end);
    }

    @Test(expected = InvalidMoveException.class)
    public void invalidWhiteOutOfBoundsMove() throws InvalidMoveException {
        start = new Position(1,3);
        p_start.pos = start;
        board.board[1][3] = p_start;

        Position end = new Position(-1,3);
        player.makeMove(board, Color.WHITE, start, end);
    }

}
