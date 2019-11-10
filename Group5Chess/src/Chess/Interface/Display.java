package Chess.Interface;

import Chess.Basics.DTextPanel;
import Chess.Structure.Config;
import Chess.Structure.Game;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.*;

public class Display {
    private JFrame appFrame = new JFrame("Groupe 5 Chess");
    Screen screen = new Screen();
    public DTextPanel currentField = new DTextPanel("From Position", 2, 5);
    public DTextPanel nextField = new DTextPanel("To Position", 2, 5);

    public void show() {
        appFrame.setVisible(true);
    }
    public void hide() {
        appFrame.setVisible(false);
    }

    private void setupFrame() {
        appFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        appFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);

                int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to quit the game?\n(All progress will be lost!)","Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Config.icon);
                if(dialogResult == JOptionPane.YES_OPTION){
                    hide();
                    Game.getGameInstance().reset();
                    Game.getGameInstance().getTitleScreen().disconnect();
                    Game.getGameInstance().getTitleScreen().show();
                }
            }
        });
        appFrame.setResizable(false);
        appFrame.setSize(Config.boardDimentions[0], Config.boardDimentions[1]);
        Config.centerWindows(appFrame);
        appFrame.setVisible(false);
    }

    public String fromText() {
        return currentField.getText();
    }

    public Display() {
        //Bottom panel
        JPanel southPanel = new JPanel();

        //From position
        currentField.addListener(new KeyUpValidadte());
        southPanel.add(currentField);
        //To position
        nextField.addListener(new KeyUpValidadte());
        southPanel.add(nextField);

        JButton button = new JButton("Move");
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Game.getGameInstance().getBoard().movePiece(currentField.getText(), nextField.getText());
                currentField.setText("");
                nextField.setText("");
                Game.getGameInstance().update();
            }
        });
        southPanel.add(button);

        Container content = appFrame.getContentPane();
        Container topContainer = Box.createHorizontalBox();
        topContainer.add(screen);

        content.add(topContainer, BorderLayout.NORTH);
        content.add(southPanel, BorderLayout.PAGE_END);

        setupFrame();
    }

    public void draw(String t) {
        screen.draw(t);
    }
}

class KeyUpValidadte extends KeyAdapter {
    @Override
    public void keyReleased(KeyEvent e) {
        String current = Game.getGameInstance().getDisplay().currentField.getText();
        String next = Game.getGameInstance().getDisplay().nextField.getText();

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            Game.getGameInstance().getBoard().movePiece(current, next);
            Game.getGameInstance().getDisplay().currentField.setText("");
            Game.getGameInstance().getDisplay().nextField.setText("");
            Game.getGameInstance().update();
            return;
        }
        if (current.length() > 1) {
            if (Game.validateInput(current)) {
                Game.getGameInstance().hightlight(new String[]{current}, Config.htmlFromColor, false);
            }
        }

        if (next.length() > 1 &&
                !current.equals(next)) {
            if (Game.validateInput(next)) {
                Game.getGameInstance().hightlight(new String[]{next}, Config.htmlToColor, false);
            }
        }

        Game.getGameInstance().update();
    }
}