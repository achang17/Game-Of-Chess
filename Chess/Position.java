package Chess;

public class Position {
    public int row;
    public int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public void setPos(int r, int c) {
        this.row = r;
        this.col = c;
    }
    public boolean isOutOfBounds(int row, int col) {
        return this.row >= row || this.col >= col || this.row < 0 || this.col < 0;
    }

}
