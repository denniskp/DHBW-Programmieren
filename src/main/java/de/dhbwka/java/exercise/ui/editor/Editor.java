package de.dhbwka.java.exercise.ui.editor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.*;

public class Editor extends JFrame {
    private String filePath = null;

    public Editor() {
        this.setLayout(new GridLayout(1, 1, 2, 2));
        this.setTitle("Editor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        JTextPane textPain = new JTextPane();
        JScrollPane scrollPain = new JScrollPane(textPain);
        scrollPain.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrollPain);

        JMenuBar bar = new JMenuBar();
        bar.setBorder(new LineBorder(Color.BLACK));

        JMenu jmFile = new JMenu("Datei");
        {
            JMenuItem jmiNew = new JMenuItem("Neu");
            jmiNew.addActionListener(a -> {
                textPain.setText("");
            });
            jmFile.add(jmiNew);
            JMenuItem jmiOpen = new JMenuItem("Öffnen");
            jmiOpen.addActionListener(a -> {
                String filepath = getFilePath();
                if (filepath == null) {
                    return;
                }
                filePath = filepath;
                try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                    while (reader.ready()) {
                        textPain.setText(textPain.getText() + reader.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            jmFile.add(jmiOpen);
            jmFile.addSeparator();
            jmFile.add("Schließen");
            jmFile.addSeparator();
            JMenuItem jmiSave = new JMenuItem("Speichern");
            jmiSave.addActionListener(a -> {
                if (filePath != null) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                        writer.write(textPain.getText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            jmFile.add(jmiSave);
            jmFile.add("Speichern unter...");
            jmFile.add("Als Webseite speichern");
            jmFile.add("Suchen");
            jmFile.addSeparator();
            jmFile.add("Versionen");
            jmFile.addSeparator();
            jmFile.add("Webseitenvorschau");
            jmFile.addSeparator();
            jmFile.add("Seite einrichten...");
            jmFile.add("Seitenansicht");
            jmFile.add("Drucken");
            jmFile.addSeparator();
            JMenu jmSendTo = new JMenu("Senden an");
            {
                jmSendTo.add("E-Mail-Empfänger");
                jmSendTo.add("E-Mail-Empfänger (zur Überarbeitung)");
                jmSendTo.add("E-Mail-Empfänger (als Anlage)");
                jmSendTo.addSeparator();
                jmSendTo.add("Verteilerempfänger...");
                jmSendTo.add("Onlinebesprechungsteilnehmer");
                jmSendTo.add("Exchange-Ordner...");
                jmSendTo.add("Fax-Empfänger...");
                jmSendTo.addSeparator();
                jmSendTo.add("Microsoft PowerPoint");
            }
            jmFile.add(jmSendTo);
            jmFile.add("Eigenschaften");
            jmFile.addSeparator();
            jmFile.add("faplog.docx");
            jmFile.add("katzenvideos_links.docx");
            jmFile.add("normale_datei.docm");
            jmFile.addSeparator();
            JMenuItem jmiExit = new JMenuItem("Beenden");
            jmiExit.addActionListener(a -> {
                if (JOptionPane.showConfirmDialog(null, "Bitte verlass uns nicht") == 0) {
                    this.dispose();
                }
            });
            jmFile.add(jmiExit);
        }
        bar.add(jmFile);

        JMenu jmEdit = new JMenu("Bearbeiten");
        {
            jmEdit.add("Bearbeiten");
            jmEdit.addSeparator();
            jmEdit.add("Rückgängig");
            jmEdit.add("Wiederholen");
            jmEdit.addSeparator();
            jmEdit.add("Ausschneiden");
            jmEdit.add("Kopieren");
            jmEdit.add("Office-Zwischenablage");
            jmEdit.add("Einfügen");
            jmEdit.add("Inhalte einfügen");
            jmEdit.add("Als Hyperlink einfügen");
            jmEdit.addSeparator();
            jmEdit.add("Löschen");
            jmEdit.add("Alles markieren");
            jmEdit.addSeparator();
            jmEdit.add("Suchen...");
            jmEdit.add("Ersetzen...");
            jmEdit.add("Gehe zu...");
            jmEdit.addSeparator();
            jmEdit.add("Verknüpfungen...");
            jmEdit.add("Objekt");
        }
        bar.add(jmEdit);

        this.setJMenuBar(bar);
    }

    private String getFilePath() {
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
        Editor editor = new Editor();
        editor.showWindow();
    }
}
