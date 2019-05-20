package Chess;

import Piece.Piece;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public Board board;
    Player white;
    Player black;
    boolean endOfGame;
    boolean checkmate;
    boolean stalemate;

    public Game() {
        this.board = new Board(8,8);
        this.board.setBoard(this.board.board);
        this.white = new Player(Color.WHITE);
        this.black = new Player(Color.BLACK);
        this.endOfGame = false;
        this.checkmate = false;
        this.stalemate = false;
    }

    public Game(Board board, Player white, Player black) {
        this.board = board;
        this.white = white;
        this.black = black;
        this.endOfGame = false;
        this.checkmate = false;
        this.stalemate = false;
    }

    //iterate through the board, and check if any of opponents piece can eat your king using
    //isvalidmove opponents piece position to your kings position
    //need: board, who's turn it is (black or white), position of your king,

    /**
     * This function will evaluate whether a specific king is in check, given a game board and a color.
     * @param color The color of the king in question (color = black if we are checking if black king is in check)
     * @param board Current state of the game board
     */
    public boolean isInCheck(Board board, Color color) {
        Position king;
        Color opponentsColor;

        if (color == Color.BLACK) {
            king = board.blackKing;
            opponentsColor = Color.WHITE;
        } else {
            king = board.whiteKing;
            opponentsColor = Color.BLACK;
        }

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.board[row][col];
                if (piece != null && piece.color != color) {
                    if (piece.isValidMove(board.board, opponentsColor, piece.pos, king)) return true;
                }
            }
        }
        return false;
    }

    /**
     *
     *
     * @param board
     * @return
     */
    private List<Position> getAllMoves(Board board) {
        List<Position> allMoves = new ArrayList<Position>();
        for (int row = 0; row < board.height; row++) {
            for (int col =0; col < board.width; col++) {
                Position pos = new Position(row, col);
                allMoves.add(pos);
            }
        }
        return allMoves;
    }

    private boolean simulateMove(Board board, Color color, Position curr, Position next) {
        Piece[][] myBoard = board.board;

        if (myBoard[curr.row][curr.col].isValidMove(myBoard, color, curr, next)) {
            myBoard[curr.row][curr.col].setPos(next);
            Piece temp = myBoard[curr.row][curr.col];
            myBoard[curr.row][curr.col] = null;
            myBoard[next.row][next.col] = temp;
            return true;
        }

        return false;
    }

    public boolean isInCheckmate(Board board, Color color) {
        if (!isInCheck(board, color)) return false;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece currPiece = board.board[row][col];
                if (currPiece != null) {
                    Board copy = board.copy();
                    List<Position> allMoves = getAllMoves(board);
                    for (int idx = 0; idx < allMoves.size(); idx++) {
                        if (simulateMove(copy, color, currPiece.pos, allMoves.get(idx))) {
                            if (!isInCheck(copy, color)) return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean isStalemate() {


        return false;
    }



}