package Chess.Basics;

public class Pawn extends Piece {

    private Piece newPiece = null;

    public void promote(Piece newPiece) {
        if (this.newPiece == null)
            this.newPiece = newPiece;
    }

    @Override
    public String Move() {
        return "Forward 1";
    }

    public Pawn(boolean isWhite) {
        super(new String[] {"♙", "♟"}, isWhite);
    }
}
