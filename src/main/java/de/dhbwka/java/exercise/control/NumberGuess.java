package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Wie ist dein Name? ");
        String username = scanner.next();

        do {
            final int randomNumber = (int) (Math.random() * 100) + 1;

            int tries = 1;
            while (true) {
                System.out.printf("%s, rate eine Zahl [1-100]: ", username);
                final int input = scanner.nextInt();

                if (input < randomNumber) {
                    System.out.printf("Versuch %d: %d ist zu niedrig.\n", tries++, input);
                } else if (input > randomNumber) {
                    System.out.printf("Versuch %d: %d ist zu hoch.\n", tries++, input);
                } else {
                    System.out.printf("Versuch %d: %d ist korrekt.\n", tries, input);
                    break;
                }
            }

            System.out.println("Was möchtest du tun?");
            System.out.println("0 - Das Spiel beenden");
            System.out.print("1 - Das Spiel fortsetzen ");
        } while (scanner.nextInt() != 0);
    }
}
