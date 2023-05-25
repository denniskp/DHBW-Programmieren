package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;

public class BMICalculator extends JFrame {
    private final JRadioButton rbnMale;
    private JTextField txtBMI;
    private JTextField txtOutput;

    public BMICalculator() {
        this.setLayout(null);
        this.setTitle("BMI Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 350);
        this.setResizable(false);

        JLabel lblWeight = new JLabel("Weight [kg]:");
        lblWeight.setBounds(60, 40, 100, 20);
        this.add(lblWeight);

        JTextField txtWeight = new JTextField();
        txtWeight.setBounds(140, 40, 140, 20);
        this.add(txtWeight);

        JLabel lblHeight = new JLabel("Body height [m]:");
        lblHeight.setBounds(60, 77, 100, 20);
        this.add(lblHeight);

        JTextField txtHeight = new JTextField();
        txtHeight.setBounds(160, 80, 140, 20);
        this.add(txtHeight);

        ButtonGroup bngSex = new ButtonGroup();

        rbnMale = new JRadioButton("male");
        rbnMale.setBounds(85, 120, 85, 20);
        bngSex.add(rbnMale);
        this.add(rbnMale);

        JRadioButton rbnFemale = new JRadioButton("female");
        rbnFemale.setBounds(170, 120, 85, 20);
        bngSex.add(rbnFemale);
        this.add(rbnFemale);

        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(98, 160, 120, 30);
        btnCalculate.addActionListener(a -> {
            double weight;
            try {
                weight = Double.parseDouble(txtWeight.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for 'weight'");
                return;
            }

            double height;
            try {
                height = Double.parseDouble(txtHeight.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for 'height'");
                return;
            }

            if ((!rbnFemale.isSelected()) && (!rbnMale.isSelected())) {
                JOptionPane.showMessageDialog(null, "Please select your sex first");
                return;
            }

            double bmi = (weight) / (height * height);
            txtBMI.setText(String.valueOf(bmi));

            String output = getWeightText(bmi);
            txtOutput.setText(output);
        });
        this.add(btnCalculate);

        JLabel lblBMI = new JLabel("BMI:");
        lblBMI.setBounds(50, 202, 40, 20);
        this.add(lblBMI);

        txtBMI = new JTextField();
        txtBMI.setBounds(80, 205, 180, 20);
        this.add(txtBMI);

        txtOutput = new JTextField();
        txtOutput.setBounds(40, 260, 260, 20);
        txtOutput.setEditable(false);
        this.add(txtOutput);
    }

    public void showWindow() {
        this.setVisible(true);
    }

    private String getWeightText(double bmi) {
        if (rbnMale.isSelected()) {
            if (bmi < 20) return "Short weight";
            else if (bmi <= 25) return "Normal weight";
        } else {
            if (bmi < 19) return "Short weight";
            else if (bmi <= 24) return "Normal weight";
        }
        if (bmi <= 30) return "Overweight";
        else if (bmi <= 40) return "Adiposity";
        else return "Massive Adiposity";
    }

    public static void main(String[] args) {
        BMICalculator bmiCalculator = new BMICalculator();
        bmiCalculator.showWindow();
    }
}
