package Chess.Basics;

import java.util.ArrayList;

public class Player {
    private PieceColor pieceColor;
    private String name;
    private ArrayList<Piece> capturedPieces = new ArrayList<>();

    public Player(String name) {this.setName(name);}
    public Player(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }
    public PieceColor getPieceColor() {
        return pieceColor;
    }
    public void capture(Piece p) {
        capturedPieces.add(p);
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getCapturedPieces() {
        return capturedPieces.toString();
    }
}
