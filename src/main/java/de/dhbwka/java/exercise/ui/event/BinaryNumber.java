package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BinaryNumber extends JFrame {
    private JLabel lblOutput;

    public BinaryNumber() {
        ImageIcon imgOff = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("off.png")));
        ImageIcon imgOn = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("on.png")));

        this.setLayout(new GridLayout(2, 1, 5, 5));
        this.setTitle("Binary Number");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnlNorth = new JPanel(new GridLayout(2, 8, 5, 5));
        for (int i = 0; i < 8; i++) {
            int finalI = i;
            JToggleButton tbn = new JToggleButton();
            tbn.setIcon(imgOff);
            tbn.setSelectedIcon(imgOn);
            tbn.addActionListener(a -> {
                int output = Integer.parseInt(lblOutput.getText());
                int buttonValue = (int) Math.pow(2, 7 - finalI);
                lblOutput.setText(String.valueOf(tbn.isSelected() ? output + buttonValue : output - buttonValue));
            });
            pnlNorth.add(tbn);
        }

        for (int i = 0; i < 8; i++) {
            pnlNorth.add(new JLabel(String.format("2^%d", 7 - i), SwingConstants.CENTER));
        }
        this.add(pnlNorth);

        JPanel pnlSouth = new JPanel();
        lblOutput = new JLabel("0");
        pnlSouth.add(lblOutput);
        this.add(pnlSouth);

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
