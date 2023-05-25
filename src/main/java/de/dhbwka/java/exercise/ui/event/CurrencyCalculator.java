package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;

public class CurrencyCalculator extends JFrame {
    public CurrencyCalculator() {
        this.setTitle("Currency converter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 100);

        JPanel pnlMain = new JPanel(new BorderLayout(5, 5));

        JTextField txtAmount = new JTextField("Please enter amount to convert");
        pnlMain.add(txtAmount, BorderLayout.NORTH);

        JButton btnEurToUsd = new JButton("EUR -> USD");
        btnEurToUsd.addActionListener(e -> {
            double value;
            try {
                value = Double.parseDouble(txtAmount.getText().replace(',', '.'));
                txtAmount.setText(String.format("%.2f", value * 1.09));
            } catch (NumberFormatException _ignored) {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
        });
        pnlMain.add(btnEurToUsd, BorderLayout.WEST);

        JButton btnUsdToEur = new JButton("USD -> EUR");
        btnUsdToEur.addActionListener(e -> {
            double value;
            try {
                value = Double.parseDouble(txtAmount.getText().replace(',', '.'));
                txtAmount.setText(String.format("%.2f", value / 1.09));
            } catch (NumberFormatException _ignored) {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
        });
        pnlMain.add(btnUsdToEur, BorderLayout.CENTER);

        JButton btnCancel = new JButton("Cancel");
        pnlMain.add(btnCancel, BorderLayout.EAST);
        btnCancel.addActionListener(e -> this.dispose());

        this.add(pnlMain);
    }

    public void showWindow() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        CurrencyCalculator currencyCalculator = new CurrencyCalculator();
        currencyCalculator.showWindow();
    }
}
