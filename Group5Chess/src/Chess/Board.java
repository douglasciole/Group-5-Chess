package Chess;
import Chess.Basics.*;

/**
 * characters source: https://jrgraphix.net/r/Unicode/25A0-25FF
 */
public class Board {
    private Square[][] grid = new Square[8][8];
    private String spacing = "  ";
    private String[] basicBoardSymbol = new String[] {"□", "■"};

    private void drawLetters() {
        System.out.printf("%sa%sb%sc%sd%se%sf%sg%sh%s\n", spacing+" ", spacing, spacing, spacing, spacing, spacing, spacing, spacing, spacing);
    }

    private void drawTile(int i, int j) {
        int selectedTile = ((j % 2 == 0) ? 0 : 1);
        if (i % 2 == 0)
            selectedTile = ((selectedTile == 0) ? 1 : 0);
        System.out.print(basicBoardSymbol[selectedTile]+spacing);
    }

    public void draw() {
        drawLetters();
        for (int i = 0; i < grid.length; i++) {
            System.out.print(8 - i + spacing);
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == null) {
                    drawTile(i, j);
                }
            }
            System.out.println(8 - i + spacing);
        }
        drawLetters();
    }
}
