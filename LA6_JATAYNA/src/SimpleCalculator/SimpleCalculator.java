package SimpleCalculator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JPanel pPanel;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JTextField tfNumber2;
    private JLabel lblResult;
    private JButton btnCompute;

    SimpleCalculator() {

        lblResult.setBorder(new LineBorder(Color.GRAY, 1, true));

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String a = tfNumber1.getText().trim();
                String b = tfNumber2.getText().trim();

                lblResult.setText(Integer.toString(operations(a, b, (String) cbOperations.getSelectedItem())));
            }
        });
    }

    public static void main(String[] args) {

        SimpleCalculator app = new SimpleCalculator();
        app.setContentPane(app.pPanel);
        app.setSize(550, 220);
        app.setTitle("Simple Calculator");
        app.setLocationRelativeTo(null);
        app.setResizable(false);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    private int operations(String x, String y, String op) {

        int a = Integer.parseInt(x);
        int b = Integer.parseInt(y);

        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };

    }
}
