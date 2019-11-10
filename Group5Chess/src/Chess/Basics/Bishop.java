package Chess.Basics;

import Chess.Structure.Config;
import Chess.Structure.Game;

import java.util.Map;

public class Bishop extends Piece{

    public Bishop(boolean isWhite) {
        super(new String[] {"♗", "♝"}, isWhite);
    }

    @Override
    public boolean isValidMove(Square from, Square to) {
        Map<String, Square> grid = Game.getGameInstance().getBoard().getGrid();

        if (to.getRow() <= 8 && to.getRow() >= 0 && to.getCol() <= 8 && to.getCol() >= 0) {
            if (Math.abs(to.getCol() - from.getCol()) == Math.abs(to.getRow() - from.getRow())) {
                int colDir = to.getCol() - from.getCol();
                int rowDir = to.getRow() - from.getRow();
                if (colDir > 0 && rowDir > 0) {
                    for (int r = 1; r <= rowDir; r++) {
                        for (int c = 1; c <= colDir; c++) {
                            if (!grid.get(Config.letters.charAt(c)+r).isEmpty()) {
                                if ((rowDir == r && colDir == c)) {
                                    if (from.getPiece().isWhite() != to.getPiece().isWhite()) {
                                        return true;
                                    }
                                } else { //it is not the last Square
                                    return false;
                                }
                            }
                        }
                    }
                } // else if (colDir > 0 && rowDir > 0) {
//                    for (int r = 1; r <= rowDir; r++) {
//                        for (int c = 1; c <= colDir; c++) {
//                            if (!grid.get(Config.letters.charAt(c) + r).isEmpty()) {
//                                if ((rowDir == r && colDir == c)) {
//                                    if (from.getPiece().isWhite() != to.getPiece().isWhite()) {
//                                        return true;
//                                    }
//                                } else { //it is not the last Square
//                                    return false;
//                                }
//                            }
//                        }
//                    }
//                } else if (colDir > 0 && rowDir > 0) {
//                    for (int r = 1; r <= rowDir; r++) {
//                        for (int c = 1; c <= colDir; c++) {
//                            if (!grid.get(Config.letters.charAt(c) + r).isEmpty()) {
//                                if ((rowDir == r && colDir == c)) {
//                                    if (from.getPiece().isWhite() != to.getPiece().isWhite()) {
//                                        return true;
//                                    }
//                                } else { //it is not the last Square
//                                    return false;
//                                }
//                            }
//                        }
//                    }
//                }else if (colDir > 0 && rowDir > 0) {
//                    for (int r = 1; r <= rowDir; r++) {
//                        for (int c = 1; c <= colDir; c++) {
//                            if (!grid.get(Config.letters.charAt(c) + r).isEmpty()) {
//                                if ((rowDir == r && colDir == c)) {
//                                    if (from.getPiece().isWhite() != to.getPiece().isWhite()) {
//                                        return true;
//                                    }
//                                } else { //it is not the last Square
//                                    return false;
//                                }
//                            }
//                        }
//                    }
//                }
                return true;
            }
        }
        return false;
    }
}
