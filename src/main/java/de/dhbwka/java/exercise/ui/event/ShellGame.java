package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ShellGame extends JFrame {
    private JTextField txtOutput;
    private final JTextField txtPlayerName;
    private int shellBall;
    private int tries;

    public ShellGame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Shell Game");
        this.setLayout(new GridLayout(4, 1, 5, 5));

        JPanel pnlPlayerName = new JPanel(new FlowLayout());
        pnlPlayerName.add(new JLabel("Player Name"));
        txtPlayerName = new JTextField();
        txtPlayerName.setColumns(25);
        pnlPlayerName.add(txtPlayerName);
        this.add(pnlPlayerName);

        JPanel pnlShells = new JPanel(new FlowLayout());
        JButton btnShell1 = new JButton("Shell 1");
        btnShell1.addActionListener(a -> {
            if (shellBall == 1) {
                correctTip(1);
            } else {
                wrongTip(1);
            }
            shellBall = (int)(Math.random() * 3) + 1;
        });
        pnlShells.add(btnShell1);
        JButton btnShell2 = new JButton("Shell 2");
        btnShell2.addActionListener(a -> {
            if (shellBall == 2) {
                correctTip(2);
            } else {
                wrongTip(2);
            }
            shellBall = (int)(Math.random() * 3) + 1;
        });
        pnlShells.add(btnShell2);
        JButton btnShell3 = new JButton("Shell 3");
        btnShell3.addActionListener(a -> {
            if (shellBall == 3) {
                correctTip(3);
            } else {
                wrongTip(3);
            }
            shellBall = (int)(Math.random() * 3) + 1;
        });
        pnlShells.add(btnShell3);
        this.add(pnlShells);

        JPanel pnlButtons = new JPanel(new FlowLayout());
        JButton btnStatistics = new JButton("Statistics");
        btnStatistics.addActionListener(a -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("IOTest/shell-game.txt"))) {
                ArrayList<Integer> score = new ArrayList<>();

                while (reader.ready()) {
                    String line = reader.readLine();
                    int lastSpace = line.lastIndexOf(' ');
                    int playerScore = Integer.parseInt(line.substring(lastSpace + 1));
                    score.add(playerScore);
                }

                double aLittleSomethingSomething = (double) score.stream().mapToInt(i -> i).sum() / score.size();
                txtOutput.setText(String.format("Success after %f attempts!", aLittleSomethingSomething));
            } catch (IOException e) {
                txtOutput.setText("There are no saved players yet");
            }
        });
        pnlButtons.add(btnStatistics);
        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(a -> this.dispose());
        pnlButtons.add(btnExit);
        this.add(pnlButtons);

        JPanel pnlOutput = new JPanel(new FlowLayout());
        txtOutput = new JTextField();
        txtOutput.setColumns(50);
        txtOutput.setEditable(false);
        pnlOutput.add(txtOutput);
        this.add(pnlOutput);

        this.pack();

        shellBall = (int)(Math.random() * 3) + 1;
        tries = 1;
    }

    private void correctTip(int shell) {
        txtOutput.setText(String.format("Attempt #%d wins: ball was below shell %d", tries, shell));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("IOTest/shell-game.txt", true))) {
            writer.write(String.format("%s %d\n", txtPlayerName.getText(), tries));
        } catch (IOException e) {
            txtOutput.setText("An error occurred while trying to save the player stats");
        }
        tries = 1;
    }

    private void wrongTip(int shell) {
        txtOutput.setText(String.format("Attempt #%d: ball wasn't below shell %d", tries++, shell));
    }

    public void showWindow() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ShellGame shellGame = new ShellGame();
        shellGame.showWindow();
    }
}
