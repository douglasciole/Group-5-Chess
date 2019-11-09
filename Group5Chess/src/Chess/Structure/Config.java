package Chess.Structure;

import java.awt.*;

public class Config {
    public static final String letters = "abcdefgh";
    public static final String spacing = "  ";
    public static final int[] boardDimentions = new int[] {550, 550};
    public static final Color screenColor = Color.WHITE;
    public static final String lineBreaker = "<br />";

    public static final Font font = new Font(Font.MONOSPACED, Font.PLAIN, 18);
    public static final String htmlFont = "font-family: monospace;";
    public static final String htmlSize = "font-size: 12px;";

    public static final String htmlHighlightOpen = "<span style=\"color: %s;\">";
    public static final String htmlHighlightClose = "</span>";
}
