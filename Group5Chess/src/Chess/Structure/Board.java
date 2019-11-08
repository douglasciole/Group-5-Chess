package Chess.Structure;
import Chess.Basics.*;

import java.util.Hashtable;
import java.util.Map;

/**
 * characters source: https://jrgraphix.net/r/Unicode/25A0-25FF
 */
public class Board {
    private Map<String, Square> grid = new Hashtable<>();

    private String drawLetters() {
        return String.format(Config.letters.charAt(0)+"%s"+Config.letters.charAt(1)+"%s"+Config.letters.charAt(2)+"%s"+Config.letters.charAt(3)+"%s"+Config.letters.charAt(4)+"%s"+Config.letters.charAt(5)+"%s"+Config.letters.charAt(6)+"%s"+Config.letters.charAt(7)+"%s"+Config.lineBreaker, Config.spacing, Config.spacing, Config.spacing, Config.spacing, Config.spacing, Config.spacing, Config.spacing, Config.spacing);
    }

    private String drawNumbers(int i) {
        return 1 + i + Config.spacing;
    }

    private void setUpWhite() {
        grid.put("a2", new Square(1, 0, new Pawn(true)));
        grid.put("b2", new Square(1, 1, new Pawn(true)));
        grid.put("c2", new Square(1, 2, new Pawn(true)));
        grid.put("d2", new Square(1, 3, new Pawn(true)));
        grid.put("e2", new Square(1, 4, new Pawn(true)));
        grid.put("f2", new Square(1, 5, new Pawn(true)));
        grid.put("g2", new Square(1, 6, new Pawn(true)));
        grid.put("h2", new Square(1, 7, new Pawn(true)));

        grid.put("a1", new Square(0, 0, new Rook(true)));
        grid.put("b1", new Square(0, 1, new Knight(true)));
        grid.put("c1", new Square(0, 2, new Bishop(true)));
        grid.put("d1", new Square(0, 3, new Queen(true)));
        grid.put("e1", new Square(0, 4, new King(true)));
        grid.put("f1", new Square(0, 5, new Bishop(true)));
        grid.put("g1", new Square(0, 6, new Knight(true)));
        grid.put("h1", new Square(0, 7, new Rook(true)));
    }

    private void setUpBlack() {
        grid.put("a7", new Square(6, 0, new Pawn(false)));
        grid.put("b7", new Square(6, 1, new Pawn(false)));
        grid.put("c7", new Square(6, 2, new Pawn(false)));
        grid.put("d7", new Square(6, 3, new Pawn(false)));
        grid.put("e7", new Square(6, 4, new Pawn(false)));
        grid.put("f7", new Square(6, 5, new Pawn(false)));
        grid.put("g7", new Square(6, 6, new Pawn(false)));
        grid.put("h7", new Square(6, 7, new Pawn(false)));

        grid.put("a8", new Square(7, 0, new Rook(false)));
        grid.put("b8", new Square(7, 1, new Knight(false)));
        grid.put("c8", new Square(7, 2, new Bishop(false)));
        grid.put("d8", new Square(7, 3, new Queen(false)));
        grid.put("e8", new Square(7, 4, new King(false)));
        grid.put("f8", new Square(7, 5, new Bishop(false)));
        grid.put("g8", new Square(7, 6, new Knight(false)));
        grid.put("h8", new Square(7, 7, new Rook(false)));
    }

    public void movePiece(String from, String to) {
        grid.get(to).changePiece(grid.get(from).getPiece());
        grid.get(from).changePiece(null);
    }

    public Board() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid.put(Config.letters.charAt(i)+""+j, new Square(j, i));
            }
        }

        setUpWhite();
        setUpBlack();
    }

    public String draw() {
        String boardDisplay = "";

        boardDisplay += drawLetters();

        for (int i = 7; i >= 0; i--) {
            boardDisplay += drawNumbers(i);

            for (int j = 0; j < 8; j++) {
                boardDisplay += grid.get(Config.letters.charAt(j)+""+(i+1)).drawTile();
            }

            boardDisplay += drawNumbers(i) + Config.lineBreaker;
        }

        boardDisplay += drawLetters();

        return boardDisplay;
    }

    public Map<String, Square> getGrid() {
        return grid;
    }
}
