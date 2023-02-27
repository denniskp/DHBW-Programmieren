package de.dhbwka.java.exercise.methods;

import java.util.Scanner;

public class Quicksort {
    private static int divide(int left, int right, int[] array) {
        int i = left;
        int j = right - 1;
        int pivot = array[right];

        while (i < j) {
            while ((array[i] <= pivot) && (i < right)) i++;
            while ((array[j] >= pivot) && (j > left)) j--;
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        if (array[i] > pivot) {
            int temp = array[i];
            array[i] = array[right];
            array[right] = temp;
        }

        return i;
    }

    private static void quicksort(int left, int right, int[] array) {
        if (left < right) {
            int divider = divide(left, right, array);
            quicksort(left, divider - 1, array);
            quicksort(divider + 1, right, array);
        }
    }

    public static void sort(int[] array) {
        quicksort(0, array.length - 1, array);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Wie viele Elemente wollen Sie einlesen?: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Geben Sie Zahl %d ein: ", i + 1);
            array[i] = scanner.nextInt();
        }

        System.out.println("Unsortierte Zahlenfolge: ");
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        sort(array);

        System.out.println("Sortierte Zahlenfolge: ");
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
