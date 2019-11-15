package Chess.Interface;

import Chess.Basics.*;
import Chess.Structure.Config;
import Chess.Structure.Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PromotionScreen {
    private JFrame appFrame = new JFrame("Promotion");
    private String position;

    public PromotionScreen(String pos) {
        this.position = pos;

        appFrame.setUndecorated(true);
        Container content = appFrame.getContentPane();
        Container topContainer = Box.createHorizontalBox();
        topContainer.setBounds(10, 10, 290, 190);

        Piece promotedPawn = Game.getGameInstance().getBoard().getGrid().get(pos).getPiece();

        Container main = Box.createVerticalBox();

        JLabel topTitle = new JLabel("Promotion");
        topTitle.setFont(new Font(Font.SERIF, Font.BOLD, 32));
        topTitle.setBorder(new EmptyBorder(20, 0, 10, 0));

        topContainer.add(Box.createHorizontalGlue());
        topContainer.add(topTitle);
        topContainer.add(Box.createHorizontalGlue());

        Container bottomContainer = Box.createHorizontalBox();
        Container bottomContainer2 = Box.createHorizontalBox();
        bottomContainer.add(Box.createHorizontalGlue());

        Font btnFont = new Font(Font.MONOSPACED, Font.BOLD, 35);

        JButton btnQueen = new JButton();
        btnQueen.setFont(btnFont);
        btnQueen.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to promote into a QUEEN?","Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Config.icon);
                if(dialogResult == JOptionPane.YES_OPTION){
                    Game.getGameInstance().getBoard().getGrid().get(position).changePiece(new Queen(promotedPawn.getColor()));
                    Game.getGameInstance().update();
                    appFrame.dispose();
                }
            }
        });
        btnQueen.setText(((promotedPawn.getColor() == PieceColor.WHITE)?"♕":"♛"));
        bottomContainer.add(btnQueen);

        bottomContainer.add(Box.createHorizontalGlue());

        JButton btnBishop = new JButton();
        btnBishop.setFont(btnFont);
        btnBishop.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to promote into a BISHOP?","Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Config.icon);
                if(dialogResult == JOptionPane.YES_OPTION){
                    Game.getGameInstance().getBoard().getGrid().get(position).changePiece(new Bishop(promotedPawn.getColor()));
                    Game.getGameInstance().update();
                    appFrame.dispose();
                }
            }
        });
        btnBishop.setText(((promotedPawn.getColor() == PieceColor.WHITE)?"♗":"♝"));
        bottomContainer.add(btnBishop);

        bottomContainer.add(Box.createHorizontalGlue());

        bottomContainer2.add(Box.createHorizontalGlue());

        JButton btnKnight = new JButton();
        btnKnight.setFont(btnFont);
        btnKnight.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to promote into a KNIGHT?","Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Config.icon);
                if(dialogResult == JOptionPane.YES_OPTION){
                    Game.getGameInstance().getBoard().getGrid().get(position).changePiece(new Knight(promotedPawn.getColor()));
                    Game.getGameInstance().update();
                    appFrame.dispose();
                }
            }
        });
        btnKnight.setText(((promotedPawn.getColor() == PieceColor.WHITE)?"♘":"♞"));
        bottomContainer2.add(btnKnight);

        bottomContainer2.add(Box.createHorizontalGlue());

        JButton btnRook = new JButton();
        btnRook.setFont(btnFont);
        btnRook.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to promote into a ROOK?","Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Config.icon);
                if(dialogResult == JOptionPane.YES_OPTION){
                    Game.getGameInstance().getBoard().getGrid().get(position).changePiece(new Rook(promotedPawn.getColor()));
                    Game.getGameInstance().update();
                    appFrame.dispose();
                }
            }
        });
        btnRook.setText(((promotedPawn.getColor() == PieceColor.WHITE)?"♖":"♜"));
        bottomContainer2.add(btnRook);


        bottomContainer2.add(Box.createHorizontalGlue());


        main.add(topContainer);
        main.add(bottomContainer);
        main.add(new JLabel(" "));
        main.add(bottomContainer2);

        content.add(main, BorderLayout.NORTH);

        appFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        appFrame.setSize(300, 200);
        Config.centerWindows(appFrame);
        appFrame.setResizable(false);
        appFrame.setVisible(true);
    }
}
