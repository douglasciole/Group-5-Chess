package Chess.Basics;

import Chess.Structure.Board;
import Chess.Structure.Config;
import Chess.Structure.Game;

import java.util.ArrayList;
import java.util.Map;

public class Rook extends Piece {

    public Rook(PieceColor color) {
        super(new String[]{"♖", "♜"}, color);
    }

    @Override
    public boolean isValidMove(Square from, Square to) {
        return from.getPiece().getPossibleMoves(from).contains(Character.toString(Config.letters.charAt(to.getCol())) + to.fixRow());
    }

    @Override
    public ArrayList<String> getPossibleMoves(Square from) {
        ArrayList<String> moves = new ArrayList<String>();
        Board board = Game.getGameInstance().getBoard();

        String pos = "";

        if (getColor() == PieceColor.WHITE) {
            for (int r = 0; r <= 7; r++) {
                pos = Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() + r);
                if (board.getGrid().get(pos).isEmpty()) {
                    moves.add(Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() + r));
                }
            }
        }

//            if ((to.getCol() == from.getCol() && to.getRow() != from.getRow()) ||
//                    (to.getCol() != from.getCol() && to.getRow() == from.getRow())) {
//                return true;
//            }

        return moves;
    }
}
