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

        for (int r1 = from.fixRow(); r1 <= 7; r1++) {
            pos = Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() + r1);

            if (board.getGrid().get(pos).isEmpty()) {
                moves.add(Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() + r1));
            }else if (board.getGrid().get(pos).getPiece().getColor() != getColor()) {
                moves.add(Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() + r1));
                break;
            }else if (board.getGrid().get(pos).getPiece().getColor() == getColor()) {
                break;
            }
        }
        for (int r2 = from.fixRow(); r2 >= 0; r2--) {
            pos = Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() - r2);

            if (board.getGrid().get(pos).isEmpty()) {
                moves.add(Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() - r2));
            }else if (board.getGrid().get(pos).getPiece().getColor() != getColor()) {
                moves.add(Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() - r2));
                break;
            }else if (board.getGrid().get(pos).getPiece().getColor() == getColor()) {
                break;
            }
        }
//        for (int c1 = from.getCol(); c1 <= 7; c1++) {
//            pos = Character.toString(Config.letters.charAt(from.getCol() + c1)) + (from.fixRow());
//
//            if (board.getGrid().get(pos).isEmpty()) {
//                moves.add(Character.toString(Config.letters.charAt(from.getCol() + c1)) + (from.fixRow()));
//            }else if (board.getGrid().get(pos).getPiece().getColor() != getColor()) {
//                moves.add(Character.toString(Config.letters.charAt(from.getCol() + c1)) + (from.fixRow()));
//                break;
//            }else if (board.getGrid().get(pos).getPiece().getColor() == getColor()) {
//                break;
//            }
//        }
//        for (int c2 = from.getCol(); c2 >= 0; c2--) {
//            pos = Character.toString(Config.letters.charAt(from.getCol() - c2)) + (from.fixRow());
//
//            if (board.getGrid().get(pos).isEmpty()) {
//                moves.add(Character.toString(Config.letters.charAt(from.getCol() - c2)) + (from.fixRow()));
//            }else if (board.getGrid().get(pos).getPiece().getColor() != getColor()) {
//                moves.add(Character.toString(Config.letters.charAt(from.getCol() - c2)) + (from.fixRow()));
//                break;
//            }else if (board.getGrid().get(pos).getPiece().getColor() == getColor()) {
//                break;
//            }
//        }

        return moves;
    }
}
