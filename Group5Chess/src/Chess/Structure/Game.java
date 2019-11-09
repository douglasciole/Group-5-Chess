package Chess.Structure;

import Chess.Basics.*;
import Chess.Interface.Display;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        {
            put(PieceColor.BLACK, new Player("Player 1"));
        }

        ;

        {
            put(PieceColor.WHITE, new Player("Player 2"));
        }
    };

    private String drawPlayers() {
        return "♔ " + players.get(PieceColor.WHITE).getName() + Config.lineBreaker +
                players.get(PieceColor.WHITE).getCapturedPieces() + Config.lineBreaker +
                "♚ " + players.get(PieceColor.BLACK).getName() + Config.lineBreaker +
                players.get(PieceColor.BLACK).getCapturedPieces();
    }

    public Game() {
        display.draw(board.draw() + Config.lineBreaker + drawPlayers());
        display.draw(board.draw() + Config.lineBreaker + drawPlayers());
    }

    public void hightlight(String[] list, String color) {
        for (int i = 0; i < list.length; i++) {
            if (board.getGrid().containsKey(list[i])) {
                board.getGrid().get(list[i]).highlight(color);
            }
        }

        //Everytime a Piece is highlighted screen has to be re-draw;
        display.draw(board.draw() + Config.lineBreaker + drawPlayers());
    }

    public Board getBoard() {
        return board;
    }

    public void askMovement() {
        String current = display.currentField.getText();
        String next = display.nextField.getText();
        if (!validateInput(current)) {
            // TODO: how to show the error message
            return;
        }
        if (!validateInput(next)) {
            // TODO: how to show the error message
            return;
        }

        //Show Selected Piece
        hightlight(new String[]{current, next}, "red");

        // TODO: make sure which class and which method I need to call here
        board.movePiece(current, next);
    }

    private static void controlDisplay(){

    }

    private static boolean validateInput(String input) {
        return input.matches("[a-h][1-8]");
    }
}
