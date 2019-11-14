package Chess.Basics;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.event.KeyAdapter;

public class DTextPanel extends JPanel {
    private JLabel label;
    private JTextField text;

    public DTextPanel(String textLabel) {
        this(textLabel, 0);

    }

    public DTextPanel(String textLabel, int limit, int textSize) {
        this(textLabel, limit);
        text.setColumns(textSize);
    }

    public DTextPanel(String textLabel, int limit) {
        label = new JLabel(textLabel);
        text = new JTextField();

        if (limit > 0) {
            text.setDocument(new LengthRestrictedDocument(limit));
        }

        add(label);
        add(text);
    }

    public String getText() {
        return text.getText();
    }

    public void setText(String t) {
        this.text.setText(t);
    }

    public void addListener(KeyAdapter adaptor) {
        text.addKeyListener(adaptor);
    }

}

class LengthRestrictedDocument extends PlainDocument {

    private final int limit;

    public LengthRestrictedDocument(int limit) {
        this.limit = limit;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException {
        if (str == null)
            return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offs, str, a);
        }
    }
}