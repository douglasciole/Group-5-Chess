package Chess.Basics;

import java.util.ArrayList;

public abstract class Piece {
    private String[] shape;
    private PieceColor color;
    private boolean firstMove = true;

    public abstract boolean isValidMove(Square from, Square to);
    public abstract ArrayList<String> getPossibleMoves(Square from);

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setMoved() {
        this.firstMove = false;
    }

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