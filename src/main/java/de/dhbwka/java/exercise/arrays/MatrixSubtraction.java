package de.dhbwka.java.exercise.arrays;

import java.util.Random;
import java.util.Scanner;

public class MatrixSubtraction {
    public static int[][] generateRandomMatrix(int rows, int columns) {
        Random random = new Random();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                matrix[i][j] = random.nextInt(100);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    public static int[][] subMatrix(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] res = new int[rows][columns];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                res[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte Anzahl der Zeilen n eingeben: ");
        int rows = scanner.nextInt();
        System.out.print("Bitte Anzahl der Spalten m eingeben: ");
        int columns = scanner.nextInt();

        int[][] matrixX = generateRandomMatrix(rows, columns);
        int[][] matrixY = generateRandomMatrix(rows, columns);

        System.out.println("X:");
        printMatrix(matrixX);

        System.out.println("Y:");
        printMatrix(matrixY);

        System.out.println("X-Y:");
        int[][] res = subMatrix(matrixX, matrixY);
        printMatrix(res);
    }
}
