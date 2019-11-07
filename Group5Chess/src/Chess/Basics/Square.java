package Chess.Basics;

import Chess.Structure.Config;

public class Square {

    private int row;
    private int col;
    private Piece p = null;
    private String[] shape = new String[] {"□", "■"};

    public Square(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Square(int row, int col, Piece p) {
        this.row = row;
        this.col = col;
        this.p = p;
    }

    public boolean isEmpty() {
        return (p == null);
    }

    public void drawTile() {
        if (isEmpty()) {
            int selectedTile = ((col % 2 == 0) ? 0 : 1);
            if (row % 2 != 0)
                selectedTile = ((selectedTile == 0) ? 1 : 0);
            System.out.print(shape[selectedTile] + Config.spacing);
        }else {
            System.out.print(p.toString() + Config.spacing);
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
