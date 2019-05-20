package Tests;

import Chess.*;
import Piece.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KingsTests {
    Board board;
    Piece p_start;
    Player player;
    Position startpos;

    @Before
    public void setUp() {
        startpos = new Position (3,3);
        p_start = new King(new Position(3,3), Color.BLACK);
        board = new Board(8,8, p_start, startpos);
        player = new Player(Color.BLACK);
    }

    @Test
    public void moveTopRight() throws InvalidMoveException {
        Position endpos = new Position(2,4);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[2][4], p_start);
    }

    @Test
    public void moveTop() throws InvalidMoveException {
        Position endpos = new Position(2,3);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[2][3], p_start);
    }

    @Test
    public void moveTopLeft() throws InvalidMoveException {
        Position endpos = new Position(2,2);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[2][2], p_start);
    }

    @Test
    public void moveLeft() throws InvalidMoveException {
        Position endpos = new Position(3,2);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[3][2], p_start);
    }

    @Test
    public void moveBotLeft() throws InvalidMoveException {
        Position endpos = new Position(4,2);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[4][2], p_start);
    }

    @Test
    public void moveBot() throws InvalidMoveException {
        Position endpos = new Position(4,3);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[4][3], p_start);
    }

    @Test
    public void moveBotRight() throws InvalidMoveException {
        Position endpos = new Position(4,4);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[4][4], p_start);
    }

    @Test
    public void moveRight() throws InvalidMoveException {
        Position endpos = new Position(3,4);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[3][4], p_start);
    }

    @Test(expected = InvalidMoveException.class)
    public void invalidMoveTwo() throws InvalidMoveException {
        Position endpos = new Position(3,5);
        player.makeMove(board, Color.BLACK, startpos, endpos);
    }
}
