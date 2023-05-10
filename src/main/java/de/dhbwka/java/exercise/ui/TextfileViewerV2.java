package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextfileViewerV2 extends JFrame {
    public TextfileViewerV2() {
        this.setTitle("Textfile Viewer V2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 340);

        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(new GridLayout());

        JTextArea txtaFileContent = new JTextArea();
        txtaFileContent.setLineWrap(true);
        txtaFileContent.setWrapStyleWord(true);

        JScrollPane scrollPain = new JScrollPane(txtaFileContent);
        scrollPain.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pnlMain.add(scrollPain);

        String filePath = getFilePath();
        String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
        this.setTitle(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.ready()) {
                String line = reader.readLine();
                System.out.println(line);
                txtaFileContent.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.add(pnlMain);
    }

    public String getFilePath() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
            }
            @Override
            public String getDescription() {
                return "Text Files";
            }
        });
        int state = fc.showOpenDialog(null);
        return state == JFileChooser.APPROVE_OPTION ? fc.getSelectedFile().getAbsolutePath() : null;
    }

    public void showWindow() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        TextfileViewerV2 frame = new TextfileViewerV2();
        frame.showWindow();
    }
}
