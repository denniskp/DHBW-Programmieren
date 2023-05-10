package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;

public class CurrencyCalculator extends JFrame {
    private JPanel pnlMain;

    public CurrencyCalculator() {
        this.setTitle("Currency converter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 100);

        pnlMain = new JPanel(new BorderLayout(5, 5));

        JTextField txtAmount = new JTextField("Please enter amount to convert");
        pnlMain.add(txtAmount, BorderLayout.NORTH);

        JButton btnEurToUsd = new JButton("EUR -> USD");
        pnlMain.add(btnEurToUsd, BorderLayout.WEST);

        JButton btnUsdToEur = new JButton("USD -> EUR");
        pnlMain.add(btnUsdToEur, BorderLayout.CENTER);

        JButton btnCancel = new JButton("Cancel");
        pnlMain.add(btnCancel, BorderLayout.EAST);

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
