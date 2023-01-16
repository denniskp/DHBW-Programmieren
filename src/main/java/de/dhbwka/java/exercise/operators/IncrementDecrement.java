package de.dhbwka.java.exercise.operators;

public class IncrementDecrement {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        j = ++i; // i = 1, j = 1
        int k = j++ + ++i; // i = 2, j = 2, k = 3
        System.out.println("k: " + k); // k: 3
        System.out.println("*: " + j++ + ++i); // *: 23 | i = 3, j = 3
        System.out.println(j++ + ++i); // 7 | i = 4, j = 4
        int m = j++ * ++i; // j = 5, i = 5, m = 20
        System.out.println("m: " + m); // m: 20
        int n = --j * --i; // j = 4, i = 4, n = 16
        System.out.println("n: " + n); // n: 16
        System.out.println("i: " + i); // i: 4
        System.out.println("j: " + j); // j: 4
    }
}
