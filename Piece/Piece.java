package Piece;

import Chess.Color;
import Chess.Position;

public abstract class Piece {
    public Position pos;
    boolean captured;
    public Color color;

    public Piece(Position pos, Color c) {
        this.pos = new Position (pos.row, pos.col);
        this.color = c;
        this.captured = false;
    }

    public abstract Piece clone();

    /**
     * @after set the row of a position attribute of a Piece.
     */
    public void setPos(Position pos) {
        this.pos.row = pos.row;
        this.pos.col = pos.col;
    }

    /**
     * @after set the captured attribute of a Piece.
     *  */
    public void setCaptured() {
        this.captured = true;
    }

    /**
     * This function will check take in a specified piece and check whether it can make the specified move.
     * This will be edited for a GUI implementation by listening for clicked positions
     *  */
    public abstract boolean isValidMove(Piece[][] board, Color c, Position curr, Position next);

    /**
     * @after Returns true if the Piece calling this method has the same color as the passed in paramter, used to check
     * whether a player is attempting to capture their own piece in the isValidMove() methods of Piece subclasses.
     *  */
    public boolean isOwnPiece(Color pieceColor, Color ownColor) {
        return pieceColor == ownColor;
    }

    /**
     *
     * Upon call this method, we have verified the next pos is a valid pos for the curr piece to move to.
     * @param piece is the piece at the next position
     * @param ownColor color of current player
     * @after Returns false if the piece at the next position is one of the current player's own piece.
     * Otherwise, we return true, meaning the current piece trying to perform a move can legally move the curr piece to
     * the next pos. If there is an opponent's piece at next pos, we set it to captured.
     */
    public boolean checkMove(Piece piece, Color ownColor) {

        if (piece == null) {
            return true;
        }

        if (piece.color == ownColor) {
            return false;
        }

        if (piece != null) {
            piece.setCaptured();
        }
        return true;
    }

    /**
     * @after Returns true if the passed in Rook Piece can take a specific spot.
     *  */
    public boolean isRookMove(Piece[][] board, Color c, Position curr, Position next) {
        if (next.isOutOfBounds(board.length, board[0].length)) return false;
        if (board[curr.row][curr.col].color != c) return false;

        if (curr.row != next.row && curr.col != next.col) return false;

        if (curr.row == next.row) {
            if (curr.col > next.col) {
                for (int i = curr.col-1; i > next.col; i--) {
                    if (board[next.row][i] != null) return false;
                }
            } else {
                for (int i = curr.col+1; i < next.col; i++) {
                    if (board[next.row][i] != null) return false;
                }
            }
        } else if (curr.col == next.col) {
            if (curr.row > next.row) {
                for (int i = curr.row-1; i > next.col; i--) {
                    if (board[i][next.col] != null) return false;
                }
            } else {
                for (int i = curr.row+1; i < next.col; i++) {
                    if (board[i][next.col] != null) return false;
                }
            }
        }

        return checkMove(board[next.row][next.col], c);
    }

    /**
     * @after Returns true if the passed in Rook Piece can take a specific spot.
     *  */
    public boolean isBishopMove(Piece[][] board, Color color, Position curr, Position next) {
        if (next.isOutOfBounds(board.length, board[0].length)) return false;
        if (board[curr.row][curr.col].color != color) return false;

        if (Math.abs(curr.row-next.row) != Math.abs(curr.col-next.col)) return false;

        boolean hasPieceInWay = false;

        if (curr.row < next.row) {
            //4
            if (curr.col < next.col) {
                for (int r = curr.row+1; r < next.row; r++) {
                    for (int c = curr.col+1; c < next.col; c++) {
                        if (board[r][c] != null) {
                            hasPieceInWay = true;
                        }
                    }
                }
            } else {
                //3
                for (int r = curr.row+1; r < next.row; r++) {
                    for (int c = curr.col-1; c > next.col; c--) {
                        if (board[r][c] != null) {
                            hasPieceInWay = true;
                        }
                    }
                }
            }
        } else if (curr.row > next.row) {
            //1
            if (curr.col < next.col) {
                for (int r = curr.row-1; r > next.row; r--) {
                    for (int c = curr.col+1; c < next.col; c++) {
                        if (board[r][c] != null) {
                            hasPieceInWay = true;
                        }
                    }
                }
            } else {
                //2
                for (int r = curr.row-1; r > next.row; r--) {
                    for (int c = curr.col-1; c > next.col; c--) {
                        if (board[r][c] != null) {
                            hasPieceInWay = true;
                        }
                    }
                }
            }
        }

        return !hasPieceInWay && checkMove(board[next.row][next.col], color);
    }
}
