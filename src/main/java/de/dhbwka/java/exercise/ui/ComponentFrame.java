package de.dhbwka.java.exercise.ui;

import javax.swing.*;

public class ComponentFrame extends JFrame {
    private JPanel pnlMain;
    private JTextField txtJTextField;
    private JPasswordField pwdJPasswordField;
    private JLabel lblJLabel;
    private JButton btnJButton;
    private JCheckBox cbJCheckBox;
    private JComboBox cbxJComboBox;
    private JRadioButton rbnJRadioButton1;
    private JRadioButton rbnJRadioButton2;
    private JRadioButton rbnJRadioButton3;
    private JToggleButton tbnJToggleButton;

    public ComponentFrame() {
        this.setTitle("Several basic Swing components");
        this.setContentPane(pnlMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 340);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ComponentFrame();
    }
}
