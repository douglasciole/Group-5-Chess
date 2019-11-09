package Chess.Basics;

import Chess.Structure.Config;
import Chess.Structure.Game;

import java.util.Map;

public class Rook extends Piece {

    public Rook(boolean isWhite) {
        super(new String[]{"♖", "♜"}, isWhite);
    }

    @Override
    public boolean isValidMove(Square from, Square to) {
        Map<String, Square> grid = Game.getGameInstance().getBoard().getGrid();
        if (to.getRow() <= 8 && to.getRow() >= 0 && to.getCol() <= 8 && to.getCol() >= 0) {
            if ((to.getCol() == from.getCol() && to.getRow() != from.getRow()) ||
                    (to.getCol() != from.getCol() && to.getRow() == from.getRow())) {
                return true;
            }
        }
        return false;
    }
}
