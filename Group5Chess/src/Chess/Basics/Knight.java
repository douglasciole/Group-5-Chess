package Chess.Basics;

import Chess.Structure.Game;

public class Knight extends Piece {

    public Knight(boolean isWhite) {
        super(new String[] {"♘", "♞"}, isWhite);
    }

    @Override
    public boolean isValidMove(Square from, Square to) {
        Game game = Game.getGameInstance();
        while (to.getRow() <= 8 && to.getCol() <= 8) {
            if (to.getRow() == from.getRow() + 1 && to.getCol() == from.getCol() + 2) {
                return true;
            } else if (to.getRow() == from.getRow() + 1 && to.getCol() == from.getCol() - 2) {
                return true;
            } else if (to.getRow() == from.getRow() - 1 && to.getCol() == from.getCol() + 2) {
                return true;
            } else if (to.getRow() == from.getRow() - 1 && to.getCol() == from.getCol() - 2) {
                return true;
            } else if (to.getRow() == from.getRow() + 2 && to.getCol() == from.getCol() + 1) {
                return true;
            } else if (to.getRow() == from.getRow() + 2 && to.getCol() == from.getCol() - 1) {
                return true;
            } else if (to.getRow() == from.getRow() - 2 && to.getCol() == from.getCol() + 1) {
                return true;
            } else if (to.getRow() == from.getRow() - 2 && to.getCol() == from.getCol() - 1) {
                return true;
            }
        }
        return false;
    }
}
