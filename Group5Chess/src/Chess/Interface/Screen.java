package Chess.Interface;

import Chess.Structure.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import Chess.Structure.Config;

import java.awt.*;

public class Screen extends JTextPane {

    public Screen() {
        configScreen();
    }

    private void configScreen() {
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(set, .4f);
        StyleConstants.setAlignment(set, StyleConstants.ALIGN_CENTER);

        this.setBorder(new EmptyBorder(20, 0, 20, 0));
        this.setPreferredSize( new Dimension( Config.boardDimentions[0], 490 ) );
        this.setHighlighter(null);
        this.setBackground(Config.screenColor);
        this.setParagraphAttributes(set, false);
        this.setFont(Config.font);
        this.setContentType("text/html");
        this.setEditable(false);
    }

    public void draw(String t) {
        setText("<html>" +
                    "<head>" +
                    "</head>" +
                    "<body align='center' style=\""+Config.htmlFont+" "+Config.htmlSize+" \">" +
                        t +
                    "</body>" +
                "</html>");
    }
}
