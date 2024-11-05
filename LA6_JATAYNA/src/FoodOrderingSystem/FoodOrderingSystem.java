package FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame {
    private JPanel pPanel;
    private JCheckBox cPizza;
    private JCheckBox cSundae;
    private JCheckBox cTea;
    private JCheckBox cSoftDrinks;
    private JCheckBox cFries;
    private JCheckBox cBurger;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;

    private final JCheckBox[] cGroupFoods = { cPizza, cBurger, cFries, cSoftDrinks, cTea, cSundae };
    private final JRadioButton[] rbGroupDiscounts = { rbNone, rb5, rb10, rb15 };

    private final double[] foodPrices = { 100, 80, 65, 55, 50, 40 };
    private final double[] discounts = { 0, 0.05, 0.10, 0.15 };



    FoodOrderingSystem() {

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double total = 0;

                // GET CHECKED FOODS
                for (int i = 0; i < cGroupFoods.length; i++) {
                    if (cGroupFoods[i].isSelected()) {
                        total += foodPrices[i];
                    }
                }

                double discount = 0;

                // GET DISCOUNT
                for (int i = 0; i < rbGroupDiscounts.length; i++) {
                    if (rbGroupDiscounts[i].isSelected()) {
                        discount = discounts[i];
                    }
                }

                // APPLY DISCOUNT
                JOptionPane.showMessageDialog(null, "The total price is Php " + String.format("%.2f", applyDiscount(total, discount)));
            }
        });

    }

    public static void main(String[] args) {
        FoodOrderingSystem app = new FoodOrderingSystem();
        app.setContentPane(app.pPanel);
        app.setSize(425, 500);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
        app.setTitle("Food Ordering System");
    }
    private double applyDiscount(double total, double discount) {

       return total - (total * discount);
    }

}