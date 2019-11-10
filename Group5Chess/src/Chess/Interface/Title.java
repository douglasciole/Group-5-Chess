package Chess.Interface;

import Chess.Basics.DTextPanel;
import Chess.Basics.PieceColor;
import Chess.Structure.Config;
import Chess.Structure.Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class Title {
    private JFrame appFrame = new JFrame("Groupe 5 Chess");
    private JLabel networkStatus = new JLabel("⌁ Connected(Room 1)");
    private boolean connected = false;
    DTextPanel player1 = new DTextPanel("♔ White", 15,15);
    DTextPanel player2 = new DTextPanel("♚ Black", 15,15);
    JButton btnNetwork = new JButton();

    public void show() {
        appFrame.setVisible(true);
    }

    public void hide() {
        appFrame.setVisible(false);
    }

    public void disconnect() {
        connected = false;
        networkStatus.setVisible(false);
        btnNetwork.setText("Network");
    }

    public void connect() {
        connected = true;
        networkStatus.setVisible(true);
        btnNetwork.setText("Disconnect");
    }

    public Title() {
        appFrame.setUndecorated(true);
        Container content = appFrame.getContentPane();
        Container topContainer = Box.createVerticalBox();
        topContainer.setBounds(10, 10, 290, 190);

        JLabel topTitle = new JLabel("Goupe 5 Chess");
        topTitle.setFont(new Font(Font.SERIF, Font.BOLD, 32));
        topTitle.setBorder(new EmptyBorder(20, 0, 10, 10));
        topContainer.add(topTitle);

        player1.setText("Player 1");
        player2.setText("Player 2");
        topContainer.add(player1);
        topContainer.add(player2);

        networkStatus.setVisible(false);
        networkStatus.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        networkStatus.setForeground(new Color(0, 128, 0));
        topContainer.add(networkStatus);

        Container bottomContainer = Box.createHorizontalBox();
        bottomContainer.add(Box.createHorizontalGlue());

        JButton btnStart = new JButton();
        btnStart.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Game.getGameInstance().setPlayerName(PieceColor.WHITE, player1.getText());
                Game.getGameInstance().setPlayerName(PieceColor.BLACK, player2.getText());
                hide();
                Game.getGameInstance().initBoard();
                Game.getGameInstance().getDisplay().show();
            }
        });
        btnStart.setText("Play >");

        btnNetwork.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connected) {
                    disconnect();
                }else {
                    connect();
                }
            }
        });
        btnNetwork.setText("Network");

        JButton btnQuit = new JButton();
        btnQuit.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to quit?","Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Config.icon);
                if(dialogResult == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        btnQuit.setText("< Quit");

        bottomContainer.add(btnQuit);
        bottomContainer.add(btnNetwork);
        bottomContainer.add(btnStart);
        bottomContainer.add(Box.createHorizontalGlue());

        content.add(topContainer, BorderLayout.NORTH);
        content.add(bottomContainer, BorderLayout.SOUTH);

        appFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        appFrame.setSize(300, 200);
        Config.centerWindows(appFrame);
        appFrame.setResizable(false);
        appFrame.setVisible(true);
    }

}
