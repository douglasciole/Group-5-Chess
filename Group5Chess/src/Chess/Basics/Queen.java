package Chess.Basics;

public class Queen extends Piece {

    public Queen(boolean isWhite) {
        super(new String[] {"♕", "♛"}, isWhite);
    }

    @Override
    public boolean isValidMove(Square from, Square to) {
        return false;
    }
}
