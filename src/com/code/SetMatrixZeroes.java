package com.code;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visit[i][j] == false && matrix[i][j] == 0) {
                    check(visit, matrix, i, j);
                    System.out.println("-------------------------");
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void check(boolean[][] visit, int[][] matrix, int i, int j) {
        for (int a = 0; a < matrix[0].length; a++) {
            if(matrix[i][a] == 0)
                visit[i][a] = false;
            else
                visit[i][a] = true;
            matrix[i][a] = 0;
        }
        for (int a = 0; a < matrix.length; a++) {
            if(matrix[a][j] == 0)
                visit[a][j] = false;
            else
                visit[a][j] = true;
            matrix[a][j] = 0;
        }

        for (int c = 0; c < matrix.length; c++) {
            for (int d = 0; d < matrix[0].length; d++) {
                System.out.print(matrix[c][d] + "\t");
            }
            System.out.println();
        }
    }
}