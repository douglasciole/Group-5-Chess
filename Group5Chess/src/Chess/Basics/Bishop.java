package Chess.Basics;

public class Bishop extends Piece{

    public Bishop(boolean isWhite) {
        super(new String[] {"♗", "♝"}, isWhite);
    }

    @Override
    public boolean isValidMove(Square from, Square to) {
        return false;
    }
}
