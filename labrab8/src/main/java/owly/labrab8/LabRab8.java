package owly.labrab8;

import java.util.Random;

public class LabRab8 {

    public static void main(String[] args) {
        int[][] A = generateMatrix(5);
        int[][] B = generateMatrix(6);

        System.out.println("Matrix A (5x5):");
        printMatrix(A);

        System.out.println("Matrix C (6x6):");
        printMatrix(B);

        // Считаем среднее арифметическое элементов обеих диагоналей
        double avg = calcDiagonalAverage(A, B);
        System.out.printf("Arithmetic mean of the diagonals: %.2f%n%n", avg);

        // Заменяем не-диагональные элементы
        replaceNonDiagonal(A, avg);
        replaceNonDiagonal(B, avg);

        System.out.println("Matrix A after replacement:");
        printMatrix(A);

        System.out.println("Matrix C after replacement:");
        printMatrix(B);
    }

    static int[][] generateMatrix(int n) {
        Random rnd = new Random();
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                m[i][j] = rnd.nextInt(100);
        return m;
    }

    static boolean isOnDiagonal(int i, int j, int n) {
        // Главная диагональ: i == j
        // Побочная диагональ: i + j == n - 1
        return i == j || i + j == n - 1;
    }

    static double calcDiagonalAverage(int[][] A, int[][] B) {
        long sum = 0;
        int count = 0;

        for (int[][] m : new int[][][] {A, B}) {
            int n = m.length;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (isOnDiagonal(i, j, n)) {
                        sum += m[i][j];
                        count++;
                    }
        }

        return (double) sum / count;
    }

    static void replaceNonDiagonal(int[][] m, double avg) {
        int n = m.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (!isOnDiagonal(i, j, n))
                    m[i][j] = (int) Math.round(avg);
    }

    static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int val : row)
                System.out.printf("%4d", val);
            System.out.println();
        }
        System.out.println();
    }
}
