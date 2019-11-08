package Chess.Structure;

import Chess.Basics.*;
import Chess.Interface.Display;


import java.util.HashMap;
import java.util.Map;

public class Game {
    private Board board = new Board();
    private Display display = new Display();
    private static Game GAME_INSTANCE;
    public static Game getGameInstance() {
        if (GAME_INSTANCE == null) {
            GAME_INSTANCE = new Game();
        }
        return GAME_INSTANCE;
    }

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

    public Board getBoard() {
        return board;
    }
}
