package Chess.Basics;

public class Moviment {
    public static boolean move(Square from, Square to) {
        from.changePiece(null);
        return true;
    }
}