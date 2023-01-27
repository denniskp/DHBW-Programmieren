package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Eratostenes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Range: ");
        int range = scanner.nextInt();

        int[] sieve = IntStream.rangeClosed(2, range).toArray();
        int[] primes = new int[0];

        while (Arrays.stream(sieve).sum() > 0) {
            // Get smallest number min in sieve
            int min = 0;
            for (int number : sieve) {
                if (number != 0) {
                    min = number;
                    break;
                }
            }

            // Add min to primes
            int[] copy = new int[primes.length + 1];
            System.arraycopy(primes, 0, copy, 0, primes.length);
            primes = copy;
            primes[primes.length - 1] = min;

            // Remove min from sieve
            for (int i = 0; i < sieve.length; ++i) {
                if (sieve[i] == 0)
                    continue;
                if (sieve[i] % min == 0)
                    sieve[i] = 0;
            }
        }

        Arrays.stream(primes).forEach(System.out::println);
    }
}
