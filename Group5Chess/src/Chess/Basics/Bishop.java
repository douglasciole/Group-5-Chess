package Chess.Basics;

public class Bishop extends Piece{
    @Override
    public String Move() {
        return "Diagonally";
    }

    public Bishop(boolean isWhite) {
        super(new String[] {"♗", "♝"}, isWhite);
    }
}
