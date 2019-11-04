package Chess.Basics;

public class Rook extends Piece {
    @Override
    public String Move() {
        return "Horizontally or vertically";
    }

    public Rook(boolean isWhite) {
        super(new String[] {"♖", "♜"}, isWhite);
    }
}
