package de.dhbwka.java.exercise.io;

import java.io.*;
import java.util.ArrayList;

public class TextFile {
    private File f;
    private ArrayList<String> s;

    public TextFile(File f) {
        this.f = f;
        this.s = new ArrayList<>();
        read();
    }

    public TextFile(String pathname) {
        this(new File(pathname));
    }

    void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            while (reader.ready()) {
                s.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void write() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
            for (String line : this.s) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.s.clear();
    }

    int availableLines() {
        return s.size();
    }

    String[] getLines() {
        return s.toArray(String[]::new);
    }

    String getLine(int i) {
        try {
            return s.get(i);
        } catch (IndexOutOfBoundsException e) {
            System.out.printf("Couldn't change line %d. An IndexOutOfBounds-Exception occurred.\n", i);
            return "";
        }
    }

    void setLine(int i, String s) {
        try {
            this.s.set(i, s);
        } catch (IndexOutOfBoundsException e) {
            System.out.printf("Couldn't change line %d. An IndexOutOfBounds-Exception occurred.\n", i);
        }
    }

    void replaceAll(String regexp, String ersatz) {
        for (int i = 0; i < this.s.size(); i++) {
            String s = getLine(i);
            s = s.replaceAll(regexp, ersatz);
            setLine(i, s);
        }
    }

    void close() {
        this.s.clear();
        this.s = null;
        this.f = null;
    }
}
