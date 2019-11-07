package Chess;
import Chess.Basics.*;
import Chess.Structure.*;
import Chess.Interface.*;
import java.util.ArrayList;

public class Driver {
    ArrayList<Piece> pieces = new ArrayList<Piece>();

    public Driver() {
        Board b = new Board();
        Display d = new Display();
        d.draw(b.draw());
    }

    public static void main(String[] args) {
        Driver d = new Driver();
    }
}
