package de.dhbwka.java.exercise.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextfileLines {
    public static void main(String[] args) {
        int firstLineToRead = 2;
        int lastLineToRead = 5;

        int fileLine = 0;
        int arrayIndex = 0;

        String[] lines = new String[lastLineToRead - firstLineToRead + 1];
        try (BufferedReader reader = new BufferedReader(new FileReader("IOTest/example.txt"))) {
            while (reader.ready()) {
                String line = reader.readLine();
                fileLine++;

                if (fileLine < firstLineToRead)
                    continue;
                if (fileLine > lastLineToRead)
                    break;

                lines[arrayIndex] = line;
                System.out.println(line);
                arrayIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Line %s - %s: ", firstLineToRead, lastLineToRead);
        for (String line : lines) {
            System.out.print(line);
        }
    }
}
