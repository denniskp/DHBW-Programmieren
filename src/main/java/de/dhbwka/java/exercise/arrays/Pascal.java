package de.dhbwka.java.exercise.arrays;

public class Pascal {
    public static void main(String[] args) {
        final int MAX_ROWS = 9;
        int[][] pyramid = new int[MAX_ROWS][];

        for (int i = 0; i < pyramid.length; ++i) {
            pyramid[i] = new int[i + 1];
            pyramid[i][0] = pyramid[i][pyramid[i].length - 1] = 1;

            if (i > 1)
                for (int j = 1; j < pyramid[i].length - 1; ++j)
                    pyramid[i][j] = pyramid[i - 1][j - 1] + pyramid[i - 1][j];
        }

        for (int i = 0; i < pyramid.length; ++i) {
            for (int j = 0; j < MAX_ROWS - i - 1; ++j)
                System.out.print(" ");
            for (int n : pyramid[i])
                System.out.printf("%2d ", n);
            System.out.println();
        }
    }
}
