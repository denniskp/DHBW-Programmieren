package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class Norm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int n = scanner.nextInt();

        int[] vector = new int[n];
        for (int i = 0; i < n; ++i) {
            System.out.printf("Bitte x_%d eingeben: ", i);
            vector[i] = scanner.nextInt();
        }

        double multiplication = 0;
        for (int i = 0; i < n; ++i) {
            multiplication += vector[i] * vector[i];
        }

        double result = Math.sqrt(multiplication);

        System.out.printf("Der Betrag von x ist %f", result);
    }
}
