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
        {put(PieceColor.BLACK, new Player("Player 1"));};
        {put(PieceColor.WHITE, new Player("Player 2"));}
    };

    private String drawPlayers() {
        return "♔ "+players.get(PieceColor.WHITE).getName()+Config.lineBreaker+
                players.get(PieceColor.WHITE).getCapturedPieces()+Config.lineBreaker+
                "♚ "+players.get(PieceColor.BLACK).getName()+Config.lineBreaker+
                players.get(PieceColor.BLACK).getCapturedPieces();
    }

    public Game() {
        display.draw(board.draw()+Config.lineBreaker+drawPlayers());

        while(true) {
            askMovement();
            display.draw(board.draw()+Config.lineBreaker+drawPlayers());
        }
    }

    public void hightlight(String[] list, String color) {
        for (int i = 0; i < list.length; i++) {
            if (board.getGrid().containsKey(list[i])) {
                board.getGrid().get(list[i]).highlight(color);
            }
        }

        //Everytime a Piece is highlighted screen has to be re-draw;
        display.draw(board.draw()+Config.lineBreaker+drawPlayers());
    }

    public Board getBoard() {
        return board;
    }

    public void askMovement() {
        Scanner scanner = new Scanner(System.in);
        String from = "";
        String to = "";
        boolean validateFrom = false;
        while (!validateFrom) {
            // TODO: how the player input the movement
            System.out.print("Input the current position of the piece you want to move:");
            from = scanner.nextLine();
            validateFrom = validateInput(from);
            if (!validateFrom) {
                System.out.println("The input is not valid.");
            }
        }

        //Show Selected Piece
        hightlight(new String[] {"a3", "b3"}, "red");

        boolean validateTo = false;
        while (!validateTo) {
            // TODO: how the player input the movement
            System.out.print("Input the position where you want the piece to move to:");
            to = scanner.nextLine();
            validateTo = validateInput(to);
            if (!validateTo) {
                System.out.println("The input is not valid.");
            }
        }

        // TODO: make sure which class and which method I need to call here
        board.movePiece(from, to);
    }

    private static boolean validateInput(String input) {
        return input.matches("[a-h][1-8]");
    }
}
