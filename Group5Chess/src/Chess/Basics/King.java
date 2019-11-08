package Chess.Basics;

public class King extends Piece {

    public King(boolean isWhite) {
        super(new String[] {"♔", "♚"}, isWhite);
    }

    @Override
    public boolean isValidMove(Square from, Square to) {
        while (to.getRow() <= 8 && to.getCol() <= 8) {
            if (to.getRow() == from.getRow() + 1 || to.getRow() == from.getRow() - 1 ||
                    to.getCol() == from.getCol() + 1 || to.getCol() == from.getCol() - 1) {
                return true;
            } else if (to.getRow() == from.getRow() + 1 && to.getCol() == from.getCol() + 1 ||
                    to.getRow() == from.getRow() - 1 && to.getCol() == from.getCol() + 1 ||
                    to.getRow() == from.getRow() + 1 && to.getCol() == from.getCol() - 1 ||
                    to.getRow() == from.getRow() - 1 && to.getCol() == from.getCol() - 1) {
                return true;
            }
        }
        return false;
    }
}
