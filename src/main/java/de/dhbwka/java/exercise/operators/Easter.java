package de.dhbwka.java.exercise.operators;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Easter {
    public static LocalDate calculateEaster(int jahr) {
        int a = jahr % 19;
        int b = jahr % 4;
        int c = jahr % 7;
        int k = jahr / 100;
        int p = (8 * k + 13) / 25;
        int q = k / 4;
        int m = (15 + k - p - q) % 30;
        int n = (4 + k - q) % 7;
        int d = (19 * a + m) % 30;
        int e = (2 * b + 4 * c + 6 * d + n) % 7;
        int ostern = (22 + d + e);

        Month month = Month.MARCH;
        if (ostern > 31) {
            month = Month.APRIL;
            ostern -= 31;
        }

        return LocalDate.of(jahr, month.getValue(), ostern);
    }

    public static void main(String[] args) {
        LocalDate easter2023 = calculateEaster(2023);
        System.out.println("Easter in year 2023: " + easter2023.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }
}
