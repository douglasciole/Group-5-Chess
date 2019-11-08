package Chess.Basics;

import Chess.Structure.Game;

public class Pawn extends Piece {

    private Piece newPiece = null;
    private boolean firstMove = true;

    public void promote(Piece newPiece) {
        if (this.newPiece == null)
            this.newPiece = newPiece;
    }

    @Override
    public boolean isValidMove(Square from, Square to) {
        Game game = Game.getGameInstance();
        boolean valid = false;
        if (to.getRow() <= 8 && to.getRow() >= 0 && to.getCol() <= 8 && to.getCol() >= 0) {
            if (isWhite()) {
                if (firstMove) {
                    if (to.getRow() == from.getRow() + 1 || to.getRow() == from.getRow() + 2) {
                        valid = true;
                        firstMove = false;
                    }
                    valid = false;
                }
                if (to.getRow() == from.getRow() + 1) {
                    valid = true;
                }
            }
            if (firstMove) {
                if (to.getRow() == from.getRow() - 1 || to.getRow() == from.getRow() - 2) {
                    valid = true;
                    firstMove = false;
                }
                valid = false;
            }
            if (to.getRow() == from.getRow() - 1) {
                valid = true;
            }
        }
        return valid;
    }

    public Pawn(boolean isWhite) {
        super(new String[] {"♙", "♟"}, isWhite);
    }
}
