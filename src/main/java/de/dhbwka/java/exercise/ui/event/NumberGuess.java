package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class NumberGuess extends JFrame {
    private final JTextField txtPlayerName;
    private final JTextField txtNumberGuess;
    private JTextField txtOutput;

    private int randomNumber;
    private int tries;

    public NumberGuess() {
        this.setLayout(new GridLayout(4, 1, 5, 5));
        this.setTitle("Number Guessing Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnlPlayerName = new JPanel(new FlowLayout());
        pnlPlayerName.add(new JLabel("Player Name"));
        txtPlayerName = new JTextField();
        txtPlayerName.setColumns(25);
        pnlPlayerName.add(txtPlayerName);
        this.add(pnlPlayerName);

        JPanel pnlNumberGuess = new JPanel(new FlowLayout());
        pnlNumberGuess.add(new JLabel("Enter number between 1 and 1000"));
        txtNumberGuess = new JTextField();
        txtNumberGuess.setColumns(15);
        txtNumberGuess.addActionListener(a -> {
            int number;
            try {
                number = Integer.parseInt(txtNumberGuess.getText());
            } catch (NumberFormatException e) {
                txtOutput.setText("Please enter a number");
                return;
            }

            if (number < randomNumber) {
                txtOutput.setText(String.format("Attempt #%d: %d -> too small!", tries++, number));
            } else if (number > randomNumber) {
                txtOutput.setText(String.format("Attempt #%d: %d -> too big!", tries++, number));
            } else {
                txtOutput.setText(String.format("Attempt #%d: %d is the correct number!", tries, number));
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("IOTest/best-player.txt", true))) {
                    writer.write(String.format("%s %d\n", txtPlayerName.getText(), tries));
                } catch (IOException e) {
                    txtOutput.setText("An error occurred while trying to save the best player");
                }
            }
        });
        pnlNumberGuess.add(txtNumberGuess);
        this.add(pnlNumberGuess);

        JPanel pnlButtons = new JPanel(new FlowLayout());
        JButton btnNewGame = new JButton("New Game");
        btnNewGame.addActionListener(a -> {
            txtNumberGuess.setText("");
            txtPlayerName.setText("");
            txtOutput.setText("");
            randomNumber = (int) (Math.random() * 1000) + 1;
            tries = 1;
        });
        pnlButtons.add(btnNewGame);
        JButton btnBestPlayer = new JButton("Best Player");
        btnBestPlayer.addActionListener(a -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("IOTest/best-player.txt"))) {
                String bestPlayerName = "";
                int bestPlayerScore = Integer.MAX_VALUE;

                // Find best player
                while (reader.ready()) {
                    String line = reader.readLine();
                    int lastSpace = line.lastIndexOf(' ');
                    int playerScore = Integer.parseInt(line.substring(lastSpace + 1));
                    if (playerScore < bestPlayerScore) {
                        bestPlayerName = line.substring(0, lastSpace);
                        bestPlayerScore = playerScore;
                    }
                }

                txtOutput.setText(String.format("%s is currently the best player with only %d attempts!", bestPlayerName, bestPlayerScore));
            } catch (IOException e) {
                txtOutput.setText("There are no best players yet. You can be the first!");
            }
        });
        pnlButtons.add(btnBestPlayer);
        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(a -> this.dispose());
        pnlButtons.add(btnExit);
        this.add(pnlButtons);

        JPanel pnlOutput = new JPanel();
        txtOutput = new JTextField();
        txtOutput.setEditable(false);
        txtOutput.setColumns(40);
        pnlOutput.add(txtOutput);
        this.add(pnlOutput);

        this.pack();

        randomNumber = (int) (Math.random() * 1000) + 1;
        tries = 1;
    }

    public void showWindow() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        NumberGuess numberGuess = new NumberGuess();
        numberGuess.showWindow();
    }
}
