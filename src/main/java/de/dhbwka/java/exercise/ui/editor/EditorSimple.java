package de.dhbwka.java.exercise.ui.editor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class EditorSimple extends JFrame {
    public EditorSimple() {
        this.setTitle("Editor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        JPanel pnlMain = new JPanel();

        JMenuBar bar = new JMenuBar();
        bar.setBorder(new LineBorder(Color.BLACK));

        JMenu jmFile = new JMenu("Datei");
        {
            jmFile.add("Neu");
            jmFile.add("Öffnen");
            jmFile.addSeparator();
            jmFile.add("Schließen");
            jmFile.addSeparator();
            jmFile.add("Speichern");
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
            jmFile.add("Beenden");
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

        this.add(pnlMain);
    }

    public void showWindow() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        EditorSimple editorSimple = new EditorSimple();
        editorSimple.showWindow();
    }
}
