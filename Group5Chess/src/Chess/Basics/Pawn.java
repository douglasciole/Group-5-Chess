package Chess.Basics;

import Chess.Structure.Board;
import Chess.Structure.Config;
import Chess.Structure.Game;

import java.util.ArrayList;

public class Pawn extends Piece {

    private Piece newPiece = null;
    private String enPassant = "";

    public void setEnPassant(String pos) {
        this.enPassant = pos;
    }

    public String getEnPassant() {
        return enPassant;
    }

    public void promote(Piece newPiece) {
        if (this.newPiece == null)
            this.newPiece = newPiece;
    }

    @Override
    public boolean isValidMove(Square from, Square to) {
        ArrayList<String> pMoves = from.getPiece().getPossibleMoves(from);
        return pMoves.contains(Character.toString(Config.letters.charAt(to.getCol())) + to.fixRow());
    }

    @Override
    public ArrayList<String> getPossibleMoves(Square from) {
        ArrayList<String> moves = new ArrayList<String>();
        Board board = Game.getGameInstance().getBoard();

        String pos = "";

        if (getColor() == PieceColor.WHITE) {
            pos = Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() + 1);
            if (from.getRow() + 1 <= 7 && (board.getGrid().get(pos).isEmpty())) {
                moves.add(Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() + 1));
            }
            pos = Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() + 2);
            if (isFirstMove() && (board.getGrid().get(pos).isEmpty())) {
                moves.add(Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() + 2));
            }
            if (from.getCol() + 1 <= 7) {
                pos = Character.toString(Config.letters.charAt(from.getCol() + 1)) + (from.fixRow() + 1);
                if ((from.getRow() + 1 <= 7) && (!board.getGrid().get(pos).isEmpty() && board.getGrid().get(pos).getPiece().getColor() != getColor())) {
                    moves.add(Character.toString(Config.letters.charAt(from.getCol() + 1)) + (from.fixRow() + 1));
                }
            }
            if (from.getCol() - 1 >= 0) {
                pos = Character.toString(Config.letters.charAt(from.getCol() - 1)) + (from.fixRow() + 1);
                if ((from.getRow() + 1 <= 7) && (!board.getGrid().get(pos).isEmpty() && board.getGrid().get(pos).getPiece().getColor() != getColor())) {
                    moves.add(Character.toString(Config.letters.charAt(from.getCol() - 1)) + (from.fixRow() + 1));
                }
            }
            /*if (!this.getEnPassant().equals("")) {
                moves.add(getEnPassant().substring(3, 5));
            }*/
        } else {
            pos = Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() - 1);
            if (from.getRow() - 1 >= 0 && (board.getGrid().get(pos).isEmpty())) {
                moves.add(Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() - 1));
            }
            pos = Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() - 2);
            if (isFirstMove() && (board.getGrid().get(pos).isEmpty())) {
                moves.add(Character.toString(Config.letters.charAt(from.getCol())) + (from.fixRow() - 2));
            }
            if (from.getCol() + 1 <= 7) {
                pos = Character.toString(Config.letters.charAt(from.getCol() + 1)) + (from.fixRow() - 1);
                if ((from.getRow() - 1 >= 0) && (!board.getGrid().get(pos).isEmpty() && board.getGrid().get(pos).getPiece().getColor() != getColor())) {
                    moves.add(Character.toString(Config.letters.charAt(from.getCol() + 1)) + (from.fixRow() - 1));
                }
            }
            if (from.getCol() - 1 >= 0) {
                pos = Character.toString(Config.letters.charAt(from.getCol() - 1)) + (from.fixRow() - 1);
                if ((from.getRow() - 1 >= 0) && (!board.getGrid().get(pos).isEmpty() && board.getGrid().get(pos).getPiece().getColor() != getColor())) {
                    moves.add(Character.toString(Config.letters.charAt(from.getCol() - 1)) + (from.fixRow() - 1));
                }
            }

            /*if (!this.getEnPassant().equals("")) {
                moves.add(getEnPassant().substring(3, 5));
            }*/
        }

        return moves;
    }

    public static String getClassName() {
        return "Chess.Basics.Pawn";
    }

    public Pawn(PieceColor color) {
        super(new String[] {"♙", "♟"}, color);
    }
}
