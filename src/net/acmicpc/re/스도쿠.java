package net.acmicpc.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2580
public class 스도쿠 {
    static int len = 9;
    static int[][] arr = new int[len][len];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        for(int i = 0; i < len; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < len; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        sudoku(0, 0);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static boolean sudoku(int x, int y) {
        if(x == len) {
            return true;
        }
        if(y == len) {
            return sudoku(x + 1, 0);
        }
        if(arr[x][y] != 0) {
            return sudoku(x, y + 1);
        }
        for(int k = 1; k < 10; k++) {
            if(check(x, y, k)) {
                arr[x][y] = k;
               if(sudoku(x, y+1))
                   return true;
                arr[x][y] = 0;
            }
        }
        return false;
    }
    static void print() {
        for(int i = 0; i < len; i++)
            System.out.println(Arrays.toString(arr[i]));
        System.out.println();
    }
    static boolean check(int x, int y, int num) {
        boolean[] nums = new boolean[10];
        // 가로
        for(int i = 0; i < 9; i++) {
            if(arr[x][i] == num)
                return false;
        }
        nums = new boolean[10];
        // 세로
        for(int i = 0; i < 9; i++) {
            if(arr[i][y] == num)
                return false;
        }
        nums = new boolean[10];
        /*
        0.0, 0.1, 0.2       0.3 0.4 0.5
        1.0, 1.1, 1.2       1.3 1.4 1.5
        2.0, 2.1, 2.2       2.3 2.4 2.5

        3.0 3.1 3.2         3.3 3.4 3.5
        4.0 4.1 4.2         4.3 4.4 4.5
        5.0 5.1 5.2         5.3 5.4 5.5
         */
        // 3*3
        int xPos = x/3*3;
        int yPos = y/3*3;
        for(int i = xPos; i < xPos+3; i++) {
            for(int j = yPos; j < yPos+3; j++) {
                if(arr[i][j] == num)
                    return false;
            }
        }
        return true;
    }
}
