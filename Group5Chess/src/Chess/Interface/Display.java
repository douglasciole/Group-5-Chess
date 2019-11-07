package Chess.Interface;

import Chess.Structure.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Display {
    JFrame appFrame;
    JTextPane screen = new JTextPane();

    private void configScreen() {
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(set, .4f);
        StyleConstants.setAlignment(set, StyleConstants.ALIGN_CENTER);

        screen.setBorder(new EmptyBorder(40, 0, 0, 0));
        screen.setHighlighter(null);
        screen.setBackground(Config.screenColor);
        screen.setParagraphAttributes(set, false);
        screen.setFont(Config.font);
        screen.setEditable(false);
    }

    public Display() {
        appFrame = new JFrame("Groupe 5 Chess");
        Container content = appFrame.getContentPane();
        Container topContainer = Box.createHorizontalBox();


        //Change Aparence of display
        configScreen();

        topContainer.add(screen);

        content.add(topContainer, BorderLayout.NORTH);
        content.add(new JButton("This is a JButton"), BorderLayout.SOUTH);

        appFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        appFrame.setResizable(false);
        appFrame.setSize(Config.boardDimentions[0],Config.boardDimentions[1]);
        appFrame.setVisible(true);

    }

    public void draw(String t) {
        screen.setText(t+"\n"+
                "♔ Player 1 \n[]\n"+
                "♚ Player 2 \n[]"
        );
    }
}
