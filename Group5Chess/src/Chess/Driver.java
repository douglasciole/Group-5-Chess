package Chess;
import Chess.Basics.*;
import Chess.Structure.*;
import Chess.Interface.*;
import java.util.ArrayList;

public class Driver {
    ArrayList<Piece> pieces = new ArrayList<Piece>();

    public Driver() {
        new Game();
    }

    public static void main(String[] args) {
        Driver d = new Driver();
    }
}
