package KeyEventActivity;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventActivity extends JFrame {
    private JPanel pPanel;
    private JTextArea editableTextArea;
    private JTextArea nonEditableTextArea;

    KeyEventActivity() {

//        editableTextArea.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                String input = editableTextArea.getText();
//                nonEditableTextArea.setText(jejefyVowels(input));
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {}
//
//            @Override
//            public void keyReleased(KeyEvent e) {}
//        });

        // used document listener cuz key listener has input delay :(
        editableTextArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String input = editableTextArea.getText();
                nonEditableTextArea.setText(jejefyVowels(input));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String input = editableTextArea.getText();
                nonEditableTextArea.setText(jejefyVowels(input));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
    }

    public static void main(String[] args) {
        KeyEventActivity app = new KeyEventActivity();
        app.setContentPane(app.pPanel);
        app.setSize(850, 400);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setLocationRelativeTo(null);
        app.setTitle("Key Event Class");
        app.setVisible(true);
    }

    private String jejefyVowels(String text) {
        char[] letters = text.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            if (isVowel(letters[i])) {
                letters[i] = Character.toUpperCase(letters[i]);
            }
        }

        return String.valueOf(letters);
    }
    private boolean isVowel(char lt) {
        lt = Character.toUpperCase(lt);

        return lt == 'A' || lt == 'E' || lt == 'I' || lt == 'O' || lt == 'U';
    }
}