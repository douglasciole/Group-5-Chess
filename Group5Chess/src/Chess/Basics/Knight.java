package Chess.Basics;

import Chess.Structure.Game;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(PieceColor color) {
        super(new String[]{"♘", "♞"}, color);
    }

    @Override
    public boolean isValidMove(Square from, Square to) {
        if (to.getRow() <= 8 && to.getRow() >= 0 && to.getCol() <= 8 && to.getCol() >= 0) {
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

    @Override
    public ArrayList<String> getPossibleMoves(Square from) {
        return null;
    }
}
