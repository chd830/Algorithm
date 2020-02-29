package net.acmicpc;

import java.util.Scanner;

public class 스도쿠re {
    static int[][] sudoku;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sudoku = new int[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sudoku[i][j] = sc.nextInt();
            }
        }
        setSudoku(0);
        print();
    }
    public static void print() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean setSudoku(int n) {
        if(n == 81) {
            return true;
        }
        int i = n/9;
        int j = n%9;
        if(sudoku[i][j] != 0) {
            return setSudoku(n+1);
        }
        for(int k = 1; k <= 9; k++) {
            if(isPossible(i, j, k)) {
                sudoku[i][j] = k;
                if(setSudoku(n+1)) {
                    return true;
                }
                sudoku[i][j] = 0;
            }
        }
        return false;
    }
    public static boolean isPossible(int x, int y, int num) {
        for(int i = 0; i < 9; i++) {
            if(sudoku[x][i] == num || sudoku[i][y] == num){
                return false;
            }
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(sudoku[3*(x/3)+i][3*(y/3)+j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
