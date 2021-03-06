package net.acmicpc;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        //0인지점을 visit에 모두 저장하고 포문으로 반복하면서 visit[i][j]가 0인위치에서만 가로줄 세로줄을 0으로 만든다.
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    visit[i][j] = true;
                }
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visit[i][j] == true) {
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
            matrix[i][a] = 0;
        }
        for (int a = 0; a < matrix.length; a++) {
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