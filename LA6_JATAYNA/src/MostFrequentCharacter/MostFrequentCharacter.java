package MostFrequentCharacter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MostFrequentCharacter extends JFrame {
    private JPanel pPanel;
    private JLabel frequentCharLabel;
    private JTextArea textArea;

    MostFrequentCharacter() {

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String input = textArea.getText();
                frequentCharLabel.setText(frequentFinder(input));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String input = textArea.getText();
                frequentCharLabel.setText(frequentFinder(input));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

    }

    public static void main(String[] args) {
        MostFrequentCharacter app = new MostFrequentCharacter();
        app.setContentPane(app.pPanel);
        app.setSize(450, 300);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setLocationRelativeTo(null);
        app.setTitle("Most Frequent Char");
        app.setVisible(true);
    }
    private String frequentFinder(String input) {
        char[] letters = input.toCharArray();
        int max = 0;
        int count;
        char frequent = 0;

        for (char curr : letters) {
            count = 0;

            for (char cmp : letters) {
                if (Character.toUpperCase(curr) == Character.toUpperCase(cmp) && curr != ' ' && curr != '\n') {
                    count++;
                }
            }

            if (count > max) {
                max = count;
                frequent = Character.toUpperCase(curr);
            }
        }
        
        return Character.toString(frequent);
    }
}