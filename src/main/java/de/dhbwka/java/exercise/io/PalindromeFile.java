package de.dhbwka.java.exercise.io;

import java.io.*;
import java.util.Scanner;

public class PalindromeFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File dir = new File("IOTest");
        dir.mkdir();
        Writer writer = new FileWriter(dir.getAbsolutePath() + "/palindromes.txt", true);
        BufferedReader bfReader = new BufferedReader(new FileReader(dir.getAbsolutePath() + "/palindromes.txt"));

        System.out.print("Bitte Wort eingeben: ");
        String word = scanner.next();

        String reversed = new StringBuilder(word).reverse().toString();
        System.out.printf("Umgekehrt: %s\n", reversed);

        boolean isPalindrome = word.equalsIgnoreCase(reversed);
        System.out.printf("%s ist %s Palindrom.\n", word, isPalindrome ? "ein" : "kein");

        if (isPalindrome) {
            writer.write(word + "\n");
            writer.close();
        }

        System.out.println("Alle bisher gefundenen Palindrome:");
        while (bfReader.ready()) {
            System.out.println(bfReader.readLine());
        }
        bfReader.close();
    }
}
