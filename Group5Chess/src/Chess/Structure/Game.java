package Chess.Structure;

import Chess.Basics.*;
import Chess.Interface.Display;
import Chess.Interface.Title;


import java.util.HashMap;
import java.util.Map;

public class Game {
    private Board board = new Board();
    private Display display = new Display();
    private Title titleScreen = new Title();
    private static Game GAME_INSTANCE;

    public static Game getGameInstance() {
        if (GAME_INSTANCE == null) {
            GAME_INSTANCE = new Game();
        }
        return GAME_INSTANCE;
    }

    private Map<PieceColor, Player> players = new HashMap<>() {
        {
            put(PieceColor.BLACK, new Player("Player 1"));
        };{
            put(PieceColor.WHITE, new Player("Player 2"));
        }
    };

    public void initBoard() {
        board = new Board();
    }

    public Player getPlayer(PieceColor color) {
        return this.players.get(color);
    }

    public void setPlayerName(PieceColor color, String name) {
        players.get(color).setName(name);
        update();
    }

    private String drawPlayers() {
        return "<div style=\"font-size: 12px;\">" +
                    "♔ " + players.get(PieceColor.WHITE).getName() + Config.lineBreaker +
                    players.get(PieceColor.WHITE).getCapturedPieces() + Config.lineBreaker +
                    "♚ " + players.get(PieceColor.BLACK).getName() + Config.lineBreaker +
                    players.get(PieceColor.BLACK).getCapturedPieces()+
                "</div>";
    }

    public Game() {
        update();
    }

    public void hightlight(String[] list, String color) {
        hightlight(list, color, true);
    }

    public void hightlight(String[] list, String color, boolean update) {
        for (int i = 0; i < list.length; i++) {
            if (board.getGrid().containsKey(list[i])) {
                board.getGrid().get(list[i]).highlight(color);
            }
        }
        //Everytime a Piece is highlighted screen has to be re-draw;
        if (update)
            update();
    }

    public void update() {
        display.draw(board.draw() + Config.lineBreaker + drawPlayers());
    }

    public void startGame() {
        setPlayerName(PieceColor.WHITE, titleScreen.getPlayer1().getText());
        setPlayerName(PieceColor.BLACK, titleScreen.getPlayer2().getText());
        titleScreen.hide();
        initBoard();
        getDisplay().show();
    }

    public Board getBoard() {
        return board;
    }

    public Display getDisplay() {
        return display;
    }

    public Title getTitleScreen() { return titleScreen; }

    public void reset() {
        players.get(PieceColor.WHITE).reset();
        players.get(PieceColor.BLACK).reset();
        board.reset();
        update();
    }

    public static boolean validateInput(String input) {
        return input.matches("[a-h][1-8]");
    }
}
