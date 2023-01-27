package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class DotProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int n = scanner.nextInt();

        int[] x = new int[n];
        for (int i = 0; i < n; ++i) {
            System.out.printf("Bitte x_%d eingeben: ", i);
            x[i] = scanner.nextInt();
        }

        int[] y = new int[n];
        for (int i = 0; i < n; ++i) {
            System.out.printf("Bitte y_%d eingeben: ", i);
            y[i] = scanner.nextInt();
        }

        double result = 0;
        for (int i = 0; i < n; ++i) {
            result += x[i] * y[i];
        }

        System.out.printf("Das Skalarprodukt von x und y ist %f", result);
    }
}
