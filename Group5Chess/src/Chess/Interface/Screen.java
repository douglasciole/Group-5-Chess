package Chess.Interface;

import Chess.Structure.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import Chess.Structure.Config;

public class Screen extends JTextPane {

    public Screen() {
        configScreen();
    }

    private void configScreen() {
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(set, .4f);
        StyleConstants.setAlignment(set, StyleConstants.ALIGN_CENTER);

        this.setBorder(new EmptyBorder(40, 0, 0, 0));
        this.setHighlighter(null);
        this.setBackground(Config.screenColor);
        this.setParagraphAttributes(set, false);
        this.setFont(Config.font);
        this.setEditable(false);
    }
}
