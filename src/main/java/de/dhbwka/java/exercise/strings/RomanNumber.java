package de.dhbwka.java.exercise.strings;

import java.util.HashMap;
import java.util.Scanner;

public class RomanNumber {
    private static final HashMap<Character, Integer> SYMBOL_MAPPER = new HashMap<>() {{
        put('I', 1); put('V', 5); put('X', 10); put('L', 50);
        put('C', 100); put('D', 500); put('M', 1000);
    }};

    public static int romanToInt(String s) {
        final int length = s.length();
        if (length == 1)
            return SYMBOL_MAPPER.get(s.charAt(0));

        int result = 0;
        for (short i = 0; i < length; i++) {
            int current = SYMBOL_MAPPER.get(s.charAt(i));
            int next = SYMBOL_MAPPER.get(s.charAt(i + 1));

            if (i == length - 2) {
                result += (current >= next ? current + next : next - current);
                break;
            }

            result += (current >= next ? current : -current);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte geben Sie eine römische Zahl ein: ");
        String number = scanner.next();

        int result = romanToInt(number);
        System.out.printf("Der Wert der Zahl %s ist %d\n", number, result);
    }
}
