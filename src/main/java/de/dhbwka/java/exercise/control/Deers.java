package de.dhbwka.java.exercise.control;

public class Deers {
    public static void main(String[] args) {
        int deers = 200;
        int years = 0;
        while (deers < 300) {
            ++years;
            deers *= 1.1;
            deers -= 15;
            System.out.printf("%d: %d Hirsche \n", years, deers);
        }
    }
}
