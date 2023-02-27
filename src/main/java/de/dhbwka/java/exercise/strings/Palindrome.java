package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte Wort eingeben: ");
        String word = scanner.next();

        String reversed = new StringBuilder(word).reverse().toString();
        System.out.printf("Umgekehrt: %s\n", reversed);

        boolean isPalindrome = word.equalsIgnoreCase(reversed);
        System.out.printf("%s ist %s Palindrom.", word, isPalindrome ? "ein" : "kein");
    }
}
