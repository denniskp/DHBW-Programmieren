package de.dhbwka.java.exercise.datatypes;

public class Round {
    private static int roundNumberCommercially(double n) {
        int integerDigit = (int) n;
        double decimals = n - integerDigit; // n % 1
        if (n >= 0)
            return decimals >= 0.5 ? integerDigit + 1 : integerDigit;
        return decimals <= -0.5 ? integerDigit - 1 : integerDigit;
    }

    public static void main(String[] args) {
        int roundedPi = roundNumberCommercially(Math.PI);
        int roundedE = roundNumberCommercially(Math.E);

        System.out.println("Rounded PI: " + roundedPi + " | Expected: " + Math.round(Math.PI));
        System.out.println("Rounded E: " + roundedE + " | Expected: " + Math.round(Math.E));

        int roundedNegPi = roundNumberCommercially(-Math.PI);
        int roundedNegE = roundNumberCommercially(-Math.E);

        System.out.println("Rounded Neg PI: " + roundedNegPi + " | Expected: " + Math.round(-Math.PI));
        System.out.println("Rounded Neg E: " + roundedNegE + " | Expected: " + Math.round(-Math.E));
    }
}
