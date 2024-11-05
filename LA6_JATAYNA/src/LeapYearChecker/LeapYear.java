package LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYear extends JFrame {
    private JPanel panel;
    private JTextField yearTextField;
    private JButton checkYearButton;

    public LeapYear() {
        checkYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String input = yearTextField.getText().trim();
                if (isLeapYear(Integer.parseInt(input))) {
                    JOptionPane.showMessageDialog(null, "Leap year");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Not a leap year");
                }
            }
        });
    }

    public static void main(String[] args) {

        // FRAME SETUP
        LeapYear app = new LeapYear();
        app.setContentPane(app.panel);
        app.setSize(375, 175);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
        app.setTitle("Leap Year Checker");
    }

    private static boolean isLeapYear(int year) {

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }
}
