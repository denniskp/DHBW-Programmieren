package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class Babylon {
    public static double calcRoot(double number) {
        double x = number;
        double xn = 1;

        while (Math.abs(xn - x) >= 0.000001) {
            System.out.println("xn: " + xn);
            x = xn;
            xn = (x + (number / x)) / 2;
        }

        return x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wurzel aus welcher Zahl ziehen? ");
        int number = scanner.nextInt();
        double result = calcRoot(number);
        System.out.printf("Die Wurzel aus %d ist %.2f\n", number, result);
    }
}
