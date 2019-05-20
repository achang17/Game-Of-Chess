package Tests;

import Chess.*;
import Piece.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomKnightTests {
    Board board;
    Piece p_start;
    Player player;
    Position startpos;

    @Before
    public void setUp() {
        startpos = new Position (3,3);
        p_start = new CustomKnight(new Position(3,3), Color.BLACK);
        board = new Board(8,8, p_start, startpos);
        player = new Player(Color.BLACK);
    }

    @Test
    public void moveTopRight() throws InvalidMoveException {
        Position endpos = new Position(1,5);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[1][5], p_start);
    }

    @Test(expected = InvalidMoveException.class)
    public void invalidTopRight() throws InvalidMoveException {
        Position endpos = new Position(2,4);
        player.makeMove(board, Color.BLACK, startpos, endpos);
    }

    @Test
    public void moveTopLeft() throws InvalidMoveException {
        Position endpos = new Position(1,1);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[1][1], p_start);

    }

    @Test(expected = InvalidMoveException.class)
    public void invalidTopLeft() throws InvalidMoveException {
        Position endpos = new Position(2,2);
        player.makeMove(board, Color.BLACK, startpos, endpos);
    }

    @Test
    public void moveBotRight() throws InvalidMoveException {
        Position endpos = new Position(5,5);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[5][5], p_start);
    }

    @Test(expected = InvalidMoveException.class)
    public void invalidBotRight() throws InvalidMoveException {
        Position endpos = new Position(4,4);
        player.makeMove(board, Color.BLACK, startpos, endpos);
    }

    @Test
    public void moveBotLeft() throws InvalidMoveException {
        Position endpos = new Position(1,5);
        player.makeMove(board, Color.BLACK, startpos, endpos);
        assertEquals(board.board[1][5], p_start);
    }

    @Test(expected = InvalidMoveException.class)
    public void invalidBotLeft() throws InvalidMoveException {
        Position endpos = new Position(4,2);
        player.makeMove(board, Color.BLACK, startpos, endpos);
    }

}
