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
    JFrame appFrame = new JFrame("Groupe 5 Chess");
    Screen screen = new Screen();

    private void setupFrame() {
        appFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        appFrame.setResizable(false);
        appFrame.setSize(Config.boardDimentions[0],Config.boardDimentions[1]);
        appFrame.setVisible(true);
    }

    public Display() {
        Container content = appFrame.getContentPane();
        Container topContainer = Box.createHorizontalBox();
        topContainer.add(screen);

        content.add(topContainer, BorderLayout.NORTH);
        content.add(new JTextField(""), BorderLayout.SOUTH);

        setupFrame();
    }

    public void draw(String t) {
        screen.setText(t);
    }
}
