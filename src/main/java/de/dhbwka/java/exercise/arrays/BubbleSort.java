package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class BubbleSort {
    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; ++i)
            if (array[i] > array[i + 1])
                return false;
        return true;
    }

    public static void sort(int[] array) {
        if (isSorted(array))
            return;

        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }

        sort(array);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            System.out.printf("Zahl %d eingeben: ", i);
            array[i] = scanner.nextInt();
        }

        sort(array);

        System.out.print("Sortiert: ");
        for (int num : array) {
            System.out.printf("%d ", num);
        }
    }
}
