package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class ChessBoard extends JPanel {
    public Square[][] squares;

    public ChessBoard(int rows, int cols) {
        super(new GridLayout(rows, cols));
        squares = new Square[rows][cols];

        drawChessBoard(rows, cols);
    }

    public void drawChessBoard(int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Square curr = new Square(row, col);
                curr.fillColor();
                this.squares[row][col] = curr;
                add(curr);
            }
        }

    }

    public void drawChessBoardWithPieces() {
        fillBishops();
        fillPawns();
        fillKings();
        fillQueens();
        fillKnights();
        fillRooks();
    }

    public void fillBishops() {
        this.squares[0][2].fillPiece("../resources/BlackBishop.png");
        this.squares[0][5].fillPiece("../resources/BlackBishop.png");

        this.squares[7][2].fillPiece("../resources/WhiteBishop.png");;
        this.squares[7][5].fillPiece("../resources/WhiteBishop.png");;
    }

    public void fillKings() {
        this.squares[0][4].fillPiece("../resources/BlackKing.png");
        this.squares[7][4].fillPiece("../resources/WhiteKing.png");
    }

    public void fillKnights() {
        this.squares[0][1].fillPiece("../resources/BlackKnight.png");
        this.squares[0][6].fillPiece("../resources/BlackKnight.png");

        this.squares[7][1].fillPiece("../resources/WhiteKnight.png");
        this.squares[7][6].fillPiece("../resources/WhiteKnight.png");
    }

    public void fillPawns() {
        for (int col = 0; col < 8; col++) {
            this.squares[1][col].fillPiece("../resources/BlackPawn.png");
            this.squares[6][col].fillPiece("../resources/WhitePawn.png");
        }
    }

    public void fillQueens() {
        this.squares[0][3].fillPiece("../resources/BlackQueen.png");
        this.squares[7][3].fillPiece("../resources/WhiteQueen.png");
    }

    public void fillRooks() {
        this.squares[0][0].fillPiece("../resources/BlackRook.png");
        this.squares[0][7].fillPiece("../resources/BlackRook.png");

        this.squares[7][0].fillPiece("../resources/WhiteRook.png");
        this.squares[7][7].fillPiece("../resources/WhiteRook.png");
    }
}
