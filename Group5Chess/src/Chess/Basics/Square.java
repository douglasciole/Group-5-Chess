package Chess.Basics;

import Chess.Structure.Config;

public class Square {

    private int row;
    private int col;
    private Piece p = null;
    private boolean highlighted = false;
    private String hightlightColor;
    private String[] shape = new String[] {"□", "■"};

    public Square(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void highlight(String c) {
        highlighted = true;
        hightlightColor = c;
    }

    public boolean isHighlighted() {
        return highlighted;
    }

    public Square(int row, int col, Piece p) {
        this.row = row;
        this.col = col;
        this.p = p;
    }

    public void changePiece(Piece p) {
        this.p = p;
    }

    public boolean isEmpty() {
        return (p == null);
    }

    public String drawTile() {
        String displayReturn = "";
        if (isEmpty()) {
            int selectedTile = ((col % 2 == 0) ? 0 : 1);
            if (row % 2 != 0)
                selectedTile = ((selectedTile == 0) ? 1 : 0);
            displayReturn = ((isHighlighted())?String.format(Config.htmlHighlightOpen, hightlightColor):"") + shape[selectedTile] + ((isHighlighted())?Config.htmlHighlightClose:"") + Config.spacing;
        }else {
            displayReturn = ((isHighlighted())?String.format(Config.htmlHighlightOpen, hightlightColor):"") + p.toString() + ((isHighlighted())?Config.htmlHighlightClose:"") + Config.spacing;
        }

        highlighted = false;
        return displayReturn;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Piece getPiece() {
        return p;
    }

}
