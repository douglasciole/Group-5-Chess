package Chess.Basics;

public class Queen extends Piece {
    @Override
    public String Move() {
        return "Like bishop and rook";
    }

    public Queen(boolean isWhite) {
        super(new String[] {"♕", "♛"}, isWhite);
    }
}
