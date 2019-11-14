package Chess.Structure;

import Chess.Basics.*;
import Chess.Interface.Display;
import Chess.Interface.Title;


import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private Board board = new Board();
    private Display display = new Display();
    private Title titleScreen = new Title();
    private ArrayList<String> suggestions = null;
    private PieceColor whoIsPlaying = PieceColor.WHITE;
    private static Game GAME_INSTANCE;

    public static Game getGameInstance() {
        if (GAME_INSTANCE == null) {
            GAME_INSTANCE = new Game();
        }
        return GAME_INSTANCE;
    }

    public void togglePlayer() {
        if (whoIsPlaying == PieceColor.WHITE)
            whoIsPlaying = PieceColor.BLACK;
        else
            whoIsPlaying = PieceColor.WHITE;
    }

    public PieceColor getCurrentPlayer() {
        return whoIsPlaying;
    }

    public void setSuggestions(ArrayList<String> list) {
        suggestions = list;
    }

    String getSugestedMoves() {
        return "<div style=\"font-size: 12px;\">Suggestions: " + suggestions + "</div>";
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
                ((getCurrentPlayer() == PieceColor.WHITE)?"&raquo; ":"") + "♔ " + players.get(PieceColor.WHITE).getName() + ((getCurrentPlayer() == PieceColor.WHITE)?" &laquo;":"") + Config.lineBreaker +
                    players.get(PieceColor.WHITE).getCapturedPieces() + Config.lineBreaker +
                ((getCurrentPlayer() == PieceColor.BLACK)?"&raquo; ":"") + "♚ " + players.get(PieceColor.BLACK).getName() + ((getCurrentPlayer() == PieceColor.BLACK)?" &laquo;":"") + Config.lineBreaker +
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
        display.draw(board.draw() + Config.lineBreaker + drawPlayers() + Config.lineBreaker + getSugestedMoves());
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

    public void requestMove(String current, String next) {
        Square selectedSquare = getBoard().getGrid().get(current);
        if (selectedSquare.getPiece().getColor() == getCurrentPlayer() || Config.adminMode) {
            if (getBoard().movePiece(current, next)) {
                getDisplay().currentField.setText("");
                getDisplay().nextField.setText("");
                getDisplay().currentField.focus();
                update();
                return;
            }
        }else {
            JOptionPane.showMessageDialog(null, "Select a piece acording to current player!", "Alert!", JOptionPane.INFORMATION_MESSAGE, Config.icon);
        }
    }

    public static boolean validateInput(String input) {
        return input.matches("[a-h][1-8]");
    }
}
