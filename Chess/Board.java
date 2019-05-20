package Chess;

import Piece.Piece;
import Piece.*;

public class Board {
    int height;
    int width;
    public Piece[][] board;
    public Position blackKing;
    public Position whiteKing;

    /**
     * This is a constructor for Board.
     * @param h Height of board
     * @param w Width of board
     */
    public Board(int h, int w) {
        this.height = h;
        this.width = w;

        Piece[][] board = new Piece[h][w];
        setBoard(board);
        this.board = board;
        this.blackKing = new Position(0,4);
        this.whiteKing = new Position(7,4);
    }

    /**
     * This is a constructor that is useful for writing unit test but will not practically be used in a gameloop.
     */
    public Board(int h, int w, Piece p, Position pos) {
        Piece[][] board = new Piece[h][w];
        board[pos.row][pos.col] = p;
        this.board = board;
    }

    public Board copy() {
        Board output = new Board(this.height, this.width);

        for (int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.width; col++) {
                if (board[row][col] != null) {
                    output.board[row][col] = this.board[row][col].clone();
                }
            }
        }
        return output;
    }

    public void setBlackKing(Position pos) {
        this.blackKing = pos;
    }
    /**
     * @after getter for the height attribute of Board, used in unit tests.
     *  */
    public int getHeight() {
        return this.height;
    }

    /**
     * @after getter for the width attribute of Board, used in unit tests.
     *  */
    public int getWidth() {
        return this.width;
    }

    /**
     * @after sets the board for a classic game of Chess, and set classic pieces in proper starting positions.
     *  */
    public void setBoard(Piece[][] board) {
        setBishops(board);
        setKingsAndQueens(board);
        setKnights(board);
        setPawns(board);
        setRooks(board);
    }

    /**
     * @after creates and places Bishop pieces in proper starting positions.
     *  */
    private void setBishops(Piece[][] board) {
        board[0][2] = new Bishop(new Position(0,2), Color.BLACK);
        board[0][5] = new Bishop(new Position(0,5), Color.BLACK);

        board[7][2] = new Bishop(new Position(7,2), Color.WHITE);
        board[7][5] = new Bishop(new Position(7,5), Color.WHITE);
    }

    /**
     * @after creates and places King and Queen pieces in proper starting positions.
     *  */
    private void setKingsAndQueens(Piece[][] board) {
        board[0][4] = new King(new Position(0,4), Color.BLACK);
        board[7][4] = new King(new Position(7,4), Color.WHITE);

        board[0][3] = new Queen(new Position(0,3),Color.BLACK);
        board[7][3] = new Queen(new Position(7,3),Color.WHITE);

    }

    /**
     * @after creates and places Knight pieces in proper starting positions.
     *  */
    private void setKnights(Piece[][] board) {
        board[0][1] = new Knight(new Position(0,1),Color.BLACK);
        board[0][6] = new Knight(new Position(0,6),Color.BLACK);

        board[7][1] = new Knight(new Position(7,1),Color.WHITE);
        board[7][6] = new Knight(new Position(7,6),Color.WHITE);

    }

    /**
     * @after creates and places Pawns pieces in proper starting positions.
     *  */
    private void setPawns(Piece[][] board) {
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(new Position(1,i), Color.BLACK);
            board[6][i] = new Pawn(new Position(6,i),Color.WHITE);
        }
    }

    /**
     * @after creates and places Rook pieces in proper starting positions.
     *  */
    private void setRooks(Piece[][] board) {
        board[0][0] = new Rook(new Position(0,0),Color.BLACK);
        board[0][7] = new Rook(new Position(0,7),Color.BLACK);

        board[7][0] = new Rook(new Position(7,0),Color.WHITE);
        board[7][7] = new Rook(new Position(7,7),Color.WHITE);
    }
}
