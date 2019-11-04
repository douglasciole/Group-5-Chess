package Chess.Basics;

public class Knight extends Piece {
    @Override
    public String Move() {
        return "Like an L";
    }

    public Knight(boolean isWhite) {
        super(new String[] {"♘", "♞"}, isWhite);
    }
}
