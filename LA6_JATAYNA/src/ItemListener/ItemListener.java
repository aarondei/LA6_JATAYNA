package ItemListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemListener extends JFrame {

    private JPanel pPanel;
    private JCheckBox pythonCheckBox;
    private JCheckBox cppCheckBox;
    private JCheckBox javaCheckBox;
    private JCheckBox cSharpCheckBox;
    private JCheckBox cCheckBox;
    private JComboBox proficiencyComboBox;
    private JLabel languageLabel;
    private JLabel proficiencyLabel;

    private final JCheckBox[] cGroupLanguages = { cCheckBox, cppCheckBox, cSharpCheckBox, javaCheckBox, pythonCheckBox };
    StringBuilder str = new StringBuilder();

    ItemListener() {

        // SHOW CHECK BOXES
        for (JCheckBox cbox : cGroupLanguages) {

            cbox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (cbox.isSelected()) {
                        languageLabel.setText(addLanguage(cbox.getText()));
                    } else {
                        languageLabel.setText(removeLanguage(cbox.getText()));
                    }
                }
            });
        }

        // SHOW COMBO BOX
        proficiencyComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proficiencyLabel.setText((String)proficiencyComboBox.getSelectedItem());
            }
        });
    }

    public static void main(String[] args) {
        ItemListener app = new ItemListener();
        app.setContentPane(app.pPanel);
        app.setSize(450, 500);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setLocationRelativeTo(null);
        app.setTitle("Item Listener");
        app.setVisible(true);
    }

    private String addLanguage(String text) {

        if (str.isEmpty()) {
            return str.append(text).toString();
        }

        return str.append(", ").append(text).toString();
    }
    private String removeLanguage(String target) {
        String[] langs = str.toString().split(", ");
        str.setLength(0);

        for (String text : langs) {
            if (!text.equals(target)) {
                addLanguage(text);
            }
        }

        return str.toString();
    }
}