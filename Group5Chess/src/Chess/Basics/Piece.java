package Chess.Basics;

public abstract class Piece {
    private String[] shape;
    private boolean isWhite;

    public abstract boolean isValidMove(Square from, Square to);

    @Override
    public String toString() {
        return shape[((isWhite())?0:1)];
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setShape(String[] shape) {
        this.shape = shape;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public Piece(String[] shape, boolean isWhite) {
        setShape(shape);
        setWhite(isWhite);
    }
}