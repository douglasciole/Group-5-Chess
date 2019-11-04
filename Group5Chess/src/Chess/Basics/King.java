package Chess.Basics;

public class King extends Piece {
    @Override
    public String Move() {
        return "One square";
    }

    public King(boolean isWhite) {
        super(new String[] {"♔", "♚"}, isWhite);
    }
}
