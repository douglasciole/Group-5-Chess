package Chess.Basics;

public class Player {
    private PieceColor pieceColor;

    public Player(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }
}
