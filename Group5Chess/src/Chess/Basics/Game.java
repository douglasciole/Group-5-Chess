package Chess.Basics;

import Chess.Structure.Board;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Board b = new Board();
        askMovement(b);
    }

    public static void askMovement(Board b) {
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
        b.movePiece(from, to);
    }

    private static boolean validateInput(String input) {
        return input.matches("[a-h][1-8]");
    }
}
