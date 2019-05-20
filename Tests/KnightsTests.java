package Tests;

import Chess.*;
import Piece.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightsTests {
    Board board;
    Piece p_start;
    Player player;
    Position startpos;

    @Before
    public void setUp() {
        startpos = new Position (3,3);
        p_start = new Knight(new Position(3,3), Color.BLACK);
        board = new Board(8,8, p_start, startpos);
        player = new Player(Color.BLACK);
    }

    @Test
    public void moveTopRight() throws InvalidMoveException {
        Position endpos = new Position(4,1);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[4][1], p_start);
    }

    @Test
    public void moveTopRight2() throws InvalidMoveException {
        Position endpos = new Position(2,5);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[2][5], p_start);
    }

    @Test(expected = InvalidMoveException.class)
    public void invalidTopRight() throws InvalidMoveException {
        Position endpos = new Position(1,5);
        player.makeMove(board, Color.BLACK, startpos, endpos);
    }

    @Test
    public void moveTopLeft() throws InvalidMoveException {
        Position endpos = new Position(1,2);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[1][2], p_start);

    }

    @Test
    public void moveTopLeft2() throws InvalidMoveException {
        Position endpos = new Position(2,1);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[2][1], p_start);

    }

    @Test(expected = InvalidMoveException.class)
    public void invalidTopLeft() throws InvalidMoveException {
        Position endpos = new Position(0,0);
        player.makeMove(board, Color.BLACK, startpos, endpos);
    }

    @Test
    public void moveBotRight() throws InvalidMoveException {
        Position endpos = new Position(5,4);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[5][4], p_start);
    }

    @Test
    public void moveBotRight2() throws InvalidMoveException {
        Position endpos = new Position(4,5);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[4][5], p_start);
    }

    @Test(expected = InvalidMoveException.class)
    public void invalidBotRight() throws InvalidMoveException {
        Position endpos = new Position(6,6);
        player.makeMove(board, Color.BLACK, startpos, endpos);
    }

    @Test
    public void moveBotLeft() throws InvalidMoveException {
        Position endpos = new Position(4,1);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[4][1], p_start);
    }

    @Test
    public void moveBotLeft2() throws InvalidMoveException {
        Position endpos = new Position(5,2);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[5][2], p_start);
    }

    @Test(expected = InvalidMoveException.class)
    public void invalidBotLeft() throws InvalidMoveException {
        Position endpos = new Position(4,0);
        player.makeMove(board, Color.BLACK, startpos, endpos);
    }

}
