package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFrame extends JFrame {

    public TextFrame(String fileName, int width, int height) {
        JTextArea txtaFileContents = new JTextArea();
        JPanel pnlMain = new JPanel(new GridLayout(1, 1));

        this.setTitle(fileName);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);

        pnlMain.add(txtaFileContents);

        String fileContents = "";
        try {
            fileContents = Files.readString(Paths.get("IOTest/" + fileName));
        } catch (IOException e) {
            System.out.println("Unable to read file");
        }

        txtaFileContents.setText(fileContents);

        this.add(pnlMain);
    }

    public void showWindow() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please enter valid program arguments: <fileName: String> <width: int> <height: int>");
            return;
        }

        String fileName = args[0];
        int width;
        try {
            width = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number for the argument 'width'");
            return;
        }
        int height;
        try {
            height = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number for the argument 'height'");
            return;
        }

        TextFrame frame = new TextFrame(fileName, width, height);
        frame.showWindow();
    }
}
