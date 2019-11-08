package Chess.Basics;

import Chess.Structure.Game;

public class Rook extends Piece {

    public Rook(boolean isWhite) {
        super(new String[]{"♖", "♜"}, isWhite);
    }

    @Override
    public boolean isValidMove(Square from, Square to) {
        Game game = Game.getGameInstance();
        if (to.getRow() <= 8 && to.getRow() >= 0 && to.getCol() <= 8 && to.getCol() >= 0) {
            if ((to.getCol() == from.getCol() && to.getRow() != from.getRow()) ||
                    (to.getCol() != from.getCol() && to.getRow() == from.getRow())) {
                return true;
            }
        }
        return false;
    }
}
