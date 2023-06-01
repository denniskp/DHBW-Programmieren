package de.dhbwka.java.exercise.collections.gas;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GasStations extends JFrame {
    private final JTextField txtStationName;
    private final JTextField txtDiesel;
    private final JTextField txtSuperE5;
    private final JTextField txtSuperE10;

    private final HashMap<String, GasPrices> gasPricesMap = new HashMap<>();

    public GasStations() {
        this.setTitle("Gas Stations");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5, 5));
        this.setSize(250, 175);

        JPanel pnlTop = new JPanel(new GridLayout(4, 2, 5, 5));
        pnlTop.add(new JLabel("Station Name"));
        txtStationName = new JTextField();
        pnlTop.add(txtStationName);
        pnlTop.add(new JLabel("Diesel"));
        txtDiesel = new JTextField();
        pnlTop.add(txtDiesel);
        pnlTop.add(new JLabel("Super E5"));
        txtSuperE5 = new JTextField();
        pnlTop.add(txtSuperE5);
        pnlTop.add(new JLabel("Super E10"));
        txtSuperE10 = new JTextField();
        pnlTop.add(txtSuperE10);
        this.add(pnlTop, BorderLayout.NORTH);

        JPanel pnlBottom = new JPanel();
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(a -> saveStationPrices());
        pnlBottom.add(btnSave);
        JButton btnShowAll = new JButton("Show All");
        btnShowAll.addActionListener(a -> showAllSavedPrices());
        pnlBottom.add(btnShowAll);
        this.add(pnlBottom, BorderLayout.SOUTH);
    }

    private double getNumberFromTextField(JTextField textField) {
        try {
            return Double.parseDouble(textField.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void showAllSavedPrices() {
        if (gasPricesMap.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please provide at least one gas prices entry", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        gasPricesMap.entrySet().stream().sorted(new GasPricesComparator()).forEach(e -> {
            sb.append(String.format("%s: %s\n", e.getKey(), e.getValue()));
        });
        JOptionPane.showMessageDialog(null, sb.toString(), "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private void saveStationPrices() {
        String stationName = txtStationName.getText();
        if (stationName.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please provide a station name", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        double diesel = getNumberFromTextField(txtDiesel);
        double superE5 = getNumberFromTextField(txtSuperE5);
        double superE10 = getNumberFromTextField(txtSuperE10);
        GasPrices gasPrices = new GasPrices(diesel, superE5, superE10);

        gasPricesMap.put(stationName, gasPrices);

        JOptionPane.showMessageDialog(null, String.format("Saved: %s (%s)", stationName, gasPrices), "Information", JOptionPane.INFORMATION_MESSAGE);

        txtStationName.setText("");
        txtDiesel.setText("");
        txtSuperE5.setText("");
        txtSuperE10.setText("");
    }

    public void showWindow() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        GasStations gasStations = new GasStations();
        gasStations.setVisible(true);
    }
}
