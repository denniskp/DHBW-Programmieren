package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class AddUp {
    public static void variantWhile() {
        Scanner scanner = new Scanner(System.in);

        int result = 0;
        while (true) {
            System.out.print("Zahl eingeben (<0 für Abbruch): ");

            int input = scanner.nextInt();
            if (input < 0)
                break;

            result += input;
        }

        System.out.println("Summe: " + result);
    }

    public static void variantDoWhile() {
        Scanner scanner = new Scanner(System.in);

        int result = 0;
        int input = 0;
        do {
            result += input;
            System.out.print("Zahl eingeben (<0 für Abbruch): ");
            input = scanner.nextInt();
        } while (input >= 0);

        System.out.println("Summe: " + result);
    }

    public static void main(String[] args) {
        variantDoWhile();
    }
}
