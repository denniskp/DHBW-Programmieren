package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;

public class BinaryNumber extends JFrame {
    public BinaryNumber() {
        this.setLayout(new GridLayout(2, 8));
        this.setTitle("Binary Number");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 7; i >= 0; i--) {
            this.add(new JButton(), BorderLayout.NORTH);
            this.add(new JLabel(String.format("2^%d", i)), BorderLayout.CENTER);
            // Test
        }

        this.add(new JLabel(), BorderLayout.SOUTH);

        this.pack();
    }

    public void showWindow() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        BinaryNumber binaryNumber = new BinaryNumber();
        binaryNumber.showWindow();
    }
}
