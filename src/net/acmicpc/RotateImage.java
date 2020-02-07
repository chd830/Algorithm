package net.acmicpc;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] copy = new int[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        for(int i = 0, a = len - 1; i < len; i++, a--) {
            for(int j = 0, b = 0; j < len; b++, j++) {
                matrix[b][a] = copy[i][j];
            }
        }
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}
