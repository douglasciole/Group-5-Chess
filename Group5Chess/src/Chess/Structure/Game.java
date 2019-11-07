package Chess.Structure;

import Chess.Basics.*;
import Chess.Interface.Display;


import java.util.HashMap;
import java.util.Map;

public class Game {
    Board board = new Board();
    Display display = new Display();

    Map<PieceColor, Player> players = new HashMap<>() {
        {put(PieceColor.BLACK, new Player("Player 1"));};
        {put(PieceColor.WHITE, new Player("Player 2"));}
    };

    private String drawPlayers() {
        return "♔ "+players.get(PieceColor.WHITE).getName()+" \n"+players.get(PieceColor.WHITE).getCapturedPieces()+"\n"+
                "♚ "+players.get(PieceColor.BLACK).getName()+" \n"+players.get(PieceColor.BLACK).getCapturedPieces();
    }

    public Game() {
        display.draw(board.draw()+"\n"+drawPlayers());
    }
}
