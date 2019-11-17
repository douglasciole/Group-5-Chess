package Chess.Basics;

import Chess.Structure.Board;
import Chess.Structure.Config;
import Chess.Structure.Game;

import java.util.ArrayList;

public class King extends Piece {

    public King(PieceColor color) {
        super(new String[] {"♔", "♚"}, color);
    }

    @Override
    public boolean isValidMove(Square from, Square to) {
        return from.getPiece().getPossibleMoves(from).contains(Character.toString(Config.letters.charAt(to.getCol())) + to.fixRow());
    }

    @Override
    public ArrayList<String> getPossibleMoves(Square from) {
        ArrayList<String> moves = new ArrayList<String>();
        ArrayList<String> retList = new ArrayList<String>();
        Board board = Game.getGameInstance().getBoard();


        if (from.getRow() + 1 <= 7) { moves.add(Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() + 1)); }
        if (from.getRow() - 1 >= 0) { moves.add(Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() - 1)); }
        if (from.getCol() + 1 <= 7) { moves.add(Character.toString(Config.letters.charAt(from.getCol() + 1)) + from.fixRow()); }
        if (from.getCol() - 1 >= 0) { moves.add(Character.toString(Config.letters.charAt(from.getCol() - 1)) + from.fixRow()); }
        if (from.getRow() + 1 <= 7 && from.getCol() + 1 <= 7) { moves.add(Character.toString(Config.letters.charAt(from.getCol() + 1)) + (from.fixRow() + 1)); }
        if (from.getRow() - 1 >= 0 && from.getCol() - 1 >= 0) { moves.add(Character.toString(Config.letters.charAt(from.getCol() - 1)) + (from.fixRow() - 1)); }
        if (from.getRow() + 1 <= 7 && from.getCol() - 1 >= 0) { moves.add(Character.toString(Config.letters.charAt(from.getCol() - 1)) + (from.fixRow() + 1)); }
        if (from.getRow() - 1 >= 0 && from.getCol() + 1 <= 7) { moves.add(Character.toString(Config.letters.charAt(from.getCol() + 1)) + (from.fixRow() - 1)); }

        for (int i = 0; i < moves.size(); i++) {
            if ((!board.getGrid().get(moves.get(i)).isEmpty() && board.getGrid().get(moves.get(i)).getPiece().getColor() != getColor()) ||
                    board.getGrid().get(moves.get(i)).isEmpty()) {
                retList.add(moves.get(i));
            }
        }

        //TODO: Verify if there is a piece before chechking if it is first moviment
        if (getColor() == PieceColor.WHITE) {
            if (isFirstMove() &&
                    board.getGrid().get("a1").getPiece().isFirstMove() &&
                    board.getGrid().get("b1").isEmpty() &&
                    board.getGrid().get("c1").isEmpty() &&
                    board.getGrid().get("d1").isEmpty())
            {
                retList.add("c1");
            }
            if (isFirstMove() &&
                    board.getGrid().get("h1").getPiece().isFirstMove() &&
                    board.getGrid().get("g1").isEmpty() &&
                    board.getGrid().get("f1").isEmpty())
            {
                retList.add("g1");
            }
        }else {
            if (isFirstMove() &&
                    board.getGrid().get("a8").getPiece().isFirstMove() &&
                    board.getGrid().get("b8").isEmpty() &&
                    board.getGrid().get("c8").isEmpty() &&
                    board.getGrid().get("d8").isEmpty())
            {
                retList.add("c8");
            }
            if (isFirstMove() &&
                    board.getGrid().get("h8").getPiece().isFirstMove() &&
                    board.getGrid().get("g8").isEmpty() &&
                    board.getGrid().get("f8").isEmpty())
            {
                retList.add("g8");
            }
        }

        moves = null;
        return retList;
    }

    public static String getClassName() {
        return "Chess.Basics.King";
    }
}
