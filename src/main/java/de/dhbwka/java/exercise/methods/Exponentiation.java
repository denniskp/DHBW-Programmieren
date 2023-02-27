package de.dhbwka.java.exercise.methods;

import java.util.Scanner;

public class Exponentiation {
    public static double xPowerN(double x, int n) {
        if (n == 0)
            return 1;
        return x * xPowerN(x, n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Geben Sie bitte die Basis ein: ");
        double x = scanner.nextDouble();
        System.out.print("Geben Sie bitte den positiven ganzzahligen Exponenten ein: ");
        int n = scanner.nextInt();

        double result = xPowerN(x, n);
        System.out.printf("%f^%d=%f\n", x, n, result);
    }
}
