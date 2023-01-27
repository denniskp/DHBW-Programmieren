package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Range: ");
        int arrSize = scanner.nextInt();

        long[] fibonacci = new long[arrSize];
        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for (int i = 2; i < arrSize; ++i) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        Arrays.stream(fibonacci).forEach(System.out::println);
    }
}
