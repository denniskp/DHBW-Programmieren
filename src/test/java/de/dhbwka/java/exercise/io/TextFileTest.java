package de.dhbwka.java.exercise.io;

public class TextFileTest {
    public static void main(String[] args) {
        TextFile textFile = new TextFile("IOTest/bla.txt");

        int availableLines = textFile.availableLines();
        System.out.println("Available lines: " + availableLines);

        String[] lines = textFile.getLines();
        System.out.println("Lines: ");
        for (String line : lines) {
            System.out.println(line);
        }

        String line5 = textFile.getLine(4);
        System.out.println("Line 5: " + line5);
        textFile.setLine(4, "______________");
        textFile.write();
        textFile.read();
        line5 = textFile.getLine(4);
        System.out.println("Line 5: " + line5);

        textFile.replaceAll("meine", "unsre");
        textFile.write();
        textFile.read();

        lines = textFile.getLines();
        System.out.println("Lines: ");
        for (String line : lines) {
            System.out.println(line);
        }

        textFile.close();
    }
}
