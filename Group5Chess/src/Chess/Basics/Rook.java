package Chess.Basics;

public class Rook extends Piece {

    public Rook(boolean isWhite) {
        super(new String[]{"♖", "♜"}, isWhite);
    }

    @Override
    public boolean isValidMove(Square from, Square to) {
        return false;
    }
}
