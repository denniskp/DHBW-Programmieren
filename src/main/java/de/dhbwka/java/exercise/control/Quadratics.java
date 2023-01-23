package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class Quadratics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("a*x^2 + b*x + c = 0 \n");

        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();
        System.out.print("c: ");
        double c = scanner.nextDouble();

        if (a == 0.0) {
            if (b == 0.0) {
                System.out.println("Die Gleichung ist degeneriert.");
            } else {
                System.out.println(-(c / b));
            }
        } else {
            double d = Math.pow(b, 2) - 4 * a * c;
            if (d >= 0.0) {
                double dSqrt = Math.sqrt(d); // Laufzeitoptimierung
                double result1 = (-b + dSqrt) / (2 * a);
                double result2 = (-b - dSqrt) / (2 * a);
                System.out.printf("x1: %.2f, x2: %.2f\n", result1, result2);
            } else {
                System.out.println("Die Lösung ist konjugiert komplex.");
            }
        }
    }
}
