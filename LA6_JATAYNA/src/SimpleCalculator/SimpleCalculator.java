package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JPanel panel;
    private JLabel lblNumber1;
    private JLabel lblNumber2;
    private JLabel lblRes;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JTextField tfNumber2;
    private JLabel lblResult;
    private JButton btnCompute;

    SimpleCalculator() {

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
        app.setContentPane(app.panel);
        app.setSize(500, 200);
        app.setTitle("Simple Calculator");
        app.setLocationRelativeTo(null);
        app.setResizable(false);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    private int operations(String x, String y, String op) {

        int a = Integer.parseInt(x);
        int b = Integer.parseInt(y);

        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }

        return 0;
    }
}
