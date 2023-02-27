package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

public class CrossTotal {
    public static int berechnen(String number) {
        int result = 0;
        for (char c : number.toCharArray()) {
            result += c - 0x30;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte Zahl für Quersumme eingeben: ");
        String number = scanner.next();

        int result = berechnen(number);
        System.out.printf("Die Quersumme von %s ist %d\n", number, result);
    }
}
