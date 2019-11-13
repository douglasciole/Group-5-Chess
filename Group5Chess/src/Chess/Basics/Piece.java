package Chess.Basics;

import java.util.ArrayList;

public abstract class Piece {
    private String[] shape;
    private PieceColor color;

    public abstract boolean isValidMove(Square from, Square to);
    public abstract ArrayList<String> getPossibleMoves(Square from);

    @Override
    public String toString() {
        return shape[((isWhite())?0:1)];
    }

    public boolean isWhite() {
        return color == PieceColor.WHITE;
    }

    public PieceColor getColor() { return color; }
    public void setColor(PieceColor color) { this.color = color; }

    public void setShape(String[] shape) {
        this.shape = shape;
    }

    public Piece(String[] shape, PieceColor color) {
        setShape(shape);
        setColor(color);
    }
}