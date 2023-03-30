package de.dhbwka.java.exercise.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class CrossTotalFile {
    public static int berechnen(String number) {
        int result = 0;
        for (char c : number.toCharArray()) {
            result += c - 0x30;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        File fileDir = new File("IOTest");
        fileDir.mkdir();
        Writer writer = new FileWriter(fileDir.getAbsolutePath() + "/crosstotals.txt", true);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte Zahl für Quersumme eingeben: ");
        String number = scanner.next();

        int result = berechnen(number);
        String strResult = String.format("Die Quersumme von %s ist %d\n", number, result);
        System.out.printf(strResult);


        writer.write(strResult);
        writer.close();
    }
}
