package Chess.Interface;

import Chess.Basics.DTextPanel;
import Chess.Basics.PieceColor;
import Chess.Basics.Square;
import Chess.Structure.Config;
import Chess.Structure.Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class Title {
    private JFrame appFrame = new JFrame(Config.gameTitle);
    private JLabel networkStatus = new JLabel("⌁ Connected(Room 1)");
    private boolean connected = false;
    private DTextPanel player1 = new DTextPanel("♔ White", 15,15);
    private DTextPanel player2 = new DTextPanel("♚ Black", 15,15);
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

    public DTextPanel getPlayer1() {
        return player1;
    }

    public DTextPanel getPlayer2() {
        return player2;
    }

    public void connect() {
        connected = true;
        networkStatus.setVisible(true);
        btnNetwork.setText("Disconnect");
    }

    public void validatePlayersNames() {
        if (getPlayer1().getText().equals("")) {
            getPlayer1().focus();
            JOptionPane.showMessageDialog(null, "Enter player 1 name!");
            return;
        }

        if (getPlayer2().getText().equals("")) {
            getPlayer2().focus();
            JOptionPane.showMessageDialog(null, "Enter player 2 name!");
            return;
        }

        Game.getGameInstance().startGame();
    }

    public Title() {
        appFrame.setUndecorated(true);
        Container content = appFrame.getContentPane();
        Container topContainer = Box.createVerticalBox();
        topContainer.setBounds(10, 10, 290, 190);

        JLabel topTitle = new JLabel(Config.gameTitle);
        topTitle.setFont(new Font(Font.SERIF, Font.BOLD, 32));
        topTitle.setBorder(new EmptyBorder(20, 0, 10, 10));
        topContainer.add(topTitle);

        player1.setText("Player 1");
        player2.setText("Player 2");
        topContainer.add(player1);
        topContainer.add(player2);

        player1.addListener(new EnterToStart());
        player2.addListener(new EnterToStart());

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
                validatePlayersNames();
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

class EnterToStart extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            Game.getGameInstance().getTitleScreen().validatePlayersNames();
        }
    }


}