package Chess.Basics;

import Chess.Structure.Board;
import Chess.Structure.Config;
import Chess.Structure.Game;

import java.util.ArrayList;
import java.util.Map;

public class Bishop extends Piece{

    public Bishop(PieceColor color) {
        super(new String[] {"♗", "♝"}, color);
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

        for (int i = 0; i < 8; i++) {
            if ((from.fixRow() + 1) + i > 8 || (from.getCol() + 1) + i > 7) {
                break;
            }

            pos = Character.toString(Config.letters.charAt((from.getCol() + 1) + i)) + ((from.fixRow() + 1) + i);
            if (board.getGrid().get(pos).isEmpty()) {
                moves.add(pos);
            }else if (board.getGrid().get(pos).getPiece().getColor() != getColor()) {
                moves.add(pos);
                break;
            }else if (board.getGrid().get(pos).getPiece().getColor() == getColor()) {
                break;
            }
        }

        for (int i = 0; i < 8; i++) {
            if ((from.fixRow() + 1) + i > 8 || (from.getCol() - 1) - i < 0) {
                break;
            }

            pos = Character.toString(Config.letters.charAt((from.getCol() - 1) - i)) + ((from.fixRow() + 1) + i);
            if (board.getGrid().get(pos).isEmpty()) {
                moves.add(pos);
            }else if (board.getGrid().get(pos).getPiece().getColor() != getColor()) {
                moves.add(pos);
                break;
            }else if (board.getGrid().get(pos).getPiece().getColor() == getColor()) {
                break;
            }
        }

        for (int i = 0; i < 8; i++) {
            if ((from.fixRow() - 1) - i < 1 || (from.getCol() + 1) + i > 7) {
                break;
            }

            pos = Character.toString(Config.letters.charAt((from.getCol() + 1) + i)) + ((from.fixRow() - 1) - i);
            if (board.getGrid().get(pos).isEmpty()) {
                moves.add(pos);
            }else if (board.getGrid().get(pos).getPiece().getColor() != getColor()) {
                moves.add(pos);
                break;
            }else if (board.getGrid().get(pos).getPiece().getColor() == getColor()) {
                break;
            }
        }

        for (int i = 0; i < 8; i++) {
            if ((from.fixRow() - 1) - i < 1 || (from.getCol() - 1) - i < 0) {
                break;
            }
            pos = Character.toString(Config.letters.charAt((from.getCol() - 1) - i)) + ((from.fixRow() - 1) - i);
            if (board.getGrid().get(pos).isEmpty()) {
                moves.add(pos);
            }else if (board.getGrid().get(pos).getPiece().getColor() != getColor()) {
                moves.add(pos);
                break;
            }else if (board.getGrid().get(pos).getPiece().getColor() == getColor()) {
                break;
            }
        }

        return moves;
    }
}
