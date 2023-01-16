package de.dhbwka.java.exercise.datatypes;

public class ShortValue {
    public static void main(String[] args) {
        short maxShortValue = 32767; // Short.MAX_VALUE
        System.out.println("Before the increase:" + maxShortValue);

        ++maxShortValue;
        System.out.println("After the increase:" + maxShortValue);

        // Das Negative Flag wird auf eins gesetzt
        // 0111 1111 ... -> 1000 0000 ...
    }
}
