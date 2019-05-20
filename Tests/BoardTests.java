package Tests;

import Chess.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTests {

    @Test
    public void testBoard(){
        Board board = new Board(8,8);

        assertEquals(board.getHeight(), 8);
        assertEquals(board.getWidth(), 8);

        board = new Board(10,8);
        assertEquals(board.getHeight(), 10);
        assertEquals(board.getWidth(), 8);
    }
}
