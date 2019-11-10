package Chess.Structure;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class Config {
    public static final String letters = "abcdefgh";
    public static final String spacing = "  ";
    public static final int[] boardDimentions = new int[] {550, 550};
    public static final Color screenColor = Color.WHITE;

    public static final String lineBreaker = "<br />";

    public static final Font font = new Font(Font.MONOSPACED, Font.PLAIN, 18);
    public static final String htmlFont = "font-family: monospace;";
    public static final String htmlSize = "font-size: 19px;";

    public static final String htmlHighlightOpen = "<span style=\"color: %s;\">";
    public static final String htmlHighlightClose = "</span>";
    public static final String htmlFromColor = "red";
    public static final String htmlMovimentColor = "blue";
    public static final String htmlToColor = "green";

    public static final ImageIcon icon = new ImageIcon("src/knight.png");

    public static void centerWindows(JFrame frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dimension.width/2-frame.getSize().width/2, dimension.height/2-frame.getSize().height/2);
    }
}