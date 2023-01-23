package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class AddUp {
    public static void main(String[] args) {
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

        result = 0;
        do {
            System.out.print("Zahl eingeben (<0 für Abbruch): ");

            int input = scanner.nextInt();
            if (input < 0)
                break;

            result += input;
        } while (true);
        System.out.println("Summe: " + result);
    }
}
