package de.dhbwka.java.exercise.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrimesFileTest {
    public static boolean isPrime(int n) {
        try (BufferedReader reader = new BufferedReader(new FileReader("IOTest/primes.txt"))) {
            while (reader.ready()) {
                if (Integer.parseInt(reader.readLine()) == n) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.printf("%d is %s prime\n", 1023, isPrime(1023) ? "a" : "not a");
        System.out.printf("%d is %s prime\n", 846, isPrime(846) ? "a" : "not a");
        System.out.printf("%d is %s prime\n", 1, isPrime(1) ? "a" : "not a");
        System.out.printf("%d is %s prime\n", 29, isPrime(29) ? "a" : "not a");
        System.out.printf("%d is %s prime\n", 99991, isPrime(99991) ? "a" : "not a");
    }
}
