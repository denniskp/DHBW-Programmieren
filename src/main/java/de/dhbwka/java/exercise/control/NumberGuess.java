package de.dhbwka.java.exercise.control;

import java.util.Scanner;

class NumberGuessGame {
    private final Scanner scanner = new Scanner(System.in);
    private final String username;

    public NumberGuessGame() {
        username = askUsername();
    }

    public String askUsername() {
        System.out.print("Wie ist dein Name? ");
        return scanner.next();
    }

    public int generateRandomNumber() {
        return (int)(Math.random() * 100);
    }

    public boolean wantsToPlayAgain() {
        System.out.println("Was möchtest du tun?");
        System.out.println("0 - Das Spiel beenden");
        System.out.print("1 - Das Spiel fortsetzen ");
        return scanner.nextInt() == 1;
    }

    public void run() {
        int randomNumber = generateRandomNumber();

        int tries = 1;
        while (true) {
            System.out.print(username + ", rate eine Zahl [1-100]: ");
            int input = scanner.nextInt();

            if (input < randomNumber) {
                System.out.printf("Versuch %d: %d ist zu niedrig.\n", tries, input);
            } else if (input > randomNumber) {
                System.out.printf("Versuch %d: %d ist zu hoch.\n", tries, input);
            } else {
                System.out.printf("Versuch %d: %d ist korrekt.\n", tries, input);
                break;
            }

            ++tries;
        }

        if (wantsToPlayAgain())
            run();
    }
}

public class NumberGuess {
    public static void main(String[] args) {
        NumberGuessGame game = new NumberGuessGame();
        game.run();
    }
}
