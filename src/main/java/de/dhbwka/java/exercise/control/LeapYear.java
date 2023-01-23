package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0)
            return false;
        if (year % 100 == 0)
            return year % 400 == 0;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welches Jahr soll auf Schaltjahr geprüft werden? ");
        int year = scanner.nextInt();

        boolean isYearLeapYear = isLeapYear(year);
        String outputMsg = year + (isYearLeapYear ? " ist ein Schaltjahr" : " ist kein Schaltjahr");
        System.out.println(outputMsg);
    }
}
