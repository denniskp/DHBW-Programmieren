package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;
import java.util.Random;

public class StandardDeviation {
    public static double getAverage(int[] arr) {
        return (double) Arrays.stream(arr).sum() / arr.length;
    }

    public static double getStandardDeviation(int[] arr) {
        double average = getAverage(arr);
        double sum = Arrays.stream(arr).mapToDouble(e -> Math.pow(e - average, 2)).sum();
        return Math.sqrt(sum / (arr.length - 1));
    }

    public static void main(String[] args) {
        Random random = new Random();

        int[] array = random.ints(100, 0, 11).toArray();

        System.out.printf("Mittelwert: %.4f \n", getAverage(array));
        System.out.printf("Standartabweichung: %.4f \n", getStandardDeviation(array));
    }
}
