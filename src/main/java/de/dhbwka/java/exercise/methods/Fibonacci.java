package de.dhbwka.java.exercise.methods;

import java.util.Scanner;

public class Fibonacci {
    public static int f(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        return f(n - 1) + f(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Wie viele Fibonacci-Zahlen wollen Sie berechnen?: ");
        int n =  scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.printf("F(%d) = %d\n", i, f(i));
        }
    }
}
