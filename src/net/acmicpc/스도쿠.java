package net.acmicpc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class 스도쿠 {
    static int[][] sudoku;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    setSudoku(i, j);
                    print();
                }
            }
        }
    }

    public static void setSudoku(int x, int y) {
        for (int i = 1; i <= 9; i++) {
            sudoku[x][y] = i;
            if (isSudoku(x, y)) {
                return;
            }
        }
    }

    public static void print() {
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(sudoku[i]));
        }
        System.out.println();
    }

    public static boolean isSudoku(int x, int y) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (!set.add(sudoku[i][y])) {
                return false;
            }
        }
        set.clear();
        for (int i = 0; i < 9; i++) {
            if (!set.add(sudoku[x][i])) {
                return false;
            }
        }
        set.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[3 * x / 3 + i][3 * y / 3 + j] != 0 && !set.add(sudoku[3 * x / 3 + i][3 * y / 3 + j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
//가로, 세로, 3*3에서 빈칸이 한자리인 위치를 찾아서 0인 위치를 모두 채울때까지 반복하면 시간초과
    static int[][] sudoku;
    static int zero;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sudoku = new int[9][9];
        zero = 0;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sudoku[i][j] = sc.nextInt();
                if(sudoku[i][j] == 0) {
                    zero++;
                }
            }
        }
        while(zero != 0) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (sudoku[i][j] == 0) {
                        setSudoku(i, j);
//                        print();
                    }
                }
            }
        }
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
//    public static void print() {
//        for(int i = 0; i < 9; i++) {
//            System.out.println(Arrays.toString(sudoku[i]));
//        }
//        System.out.println();
//    }
    public static void setSudoku(int x, int y) {
        int cnt = 0;
        int[] arr = new int[10];
        Arrays.fill(arr, 1);
        //3*3에서 0이 몇개나 있는지 확인하기
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(sudoku[3*(x/3)+i][3*(y/3)+j] == 0) {
                    cnt++;
                }
                else {
                    arr[sudoku[3*(x/3)+i][3*(y/3)+j]]--;
                }
            }
        }
        if(cnt == 1) {
            sudoku[x][y] = getNum(arr);
            zero--;
            return;
        }
        cnt = 0;
        Arrays.fill(arr, 1);
        //열에서 0이 몇 개나 있는지 검사하기
        for(int i = 0; i < 9; i++) {
            if(sudoku[i][y] == 0) {
                cnt++;
            }
            else {
                arr[sudoku[i][y]]--;
            }
        }
        if(cnt == 1) {
            sudoku[x][y] = getNum(arr);
            zero--;
            return;
        }
        cnt = 0;
        Arrays.fill(arr, 1);
        //행에서 0이 몇 개나 있는지 검사하기
        for(int i = 0; i < 9; i++) {
            if(sudoku[x][i] == 0) {
                cnt++;
            }
            else {
                arr[sudoku[x][i]]--;
            }
        }
        if(cnt == 1) {
            sudoku[x][y] = getNum(arr);
            zero--;
            return;
        }
    }

    public static int getNum(int[] arr) {
        for(int i = 1; i <= 9; i++) {
            if(arr[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
*/
