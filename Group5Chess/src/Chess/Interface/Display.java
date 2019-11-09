package Chess.Interface;

import Chess.Structure.Config;
import Chess.Structure.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Display {
    JFrame appFrame = new JFrame("Groupe 5 Chess");
    Screen screen = new Screen();
    public JTextField currentField;
    public JTextField nextField;

    private void setupFrame() {
        appFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        appFrame.setResizable(false);
        appFrame.setSize(Config.boardDimentions[0], Config.boardDimentions[1]);
        appFrame.setVisible(true);
    }

    public Display() {
        Action action = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Game.getGameInstance().askMovement();
            }
        };
        JPanel southPanel = new JPanel();
        JLabel currentLabel = new JLabel("Current Position");
        currentField = new JTextField(5);
        southPanel.add(currentLabel);
        southPanel.add(currentField);

        JLabel nextLabel = new JLabel("Next Position");
        nextField = new JTextField(5);
        southPanel.add(nextLabel);
        southPanel.add(nextField);

        JButton button = new JButton("Move");
        button.addActionListener( action );
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