package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2580
public class 스도쿠 {
    static int[][] arr = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        sudoku(0, 0);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static boolean sudoku(int x, int y) {
        if (y == 9)
            return sudoku(x + 1, 0);
        if(x == 9)
            return true;
        if(arr[x][y] != 0)
            return sudoku(x, y + 1);
        for(int i = 1; i < 10; i++) {
            if(check(x, y, i)) {
                arr[x][y] = i;
                if(sudoku(x, y+1))
                    return true;
                arr[x][y] = 0;
            }
        }
        return false;
    }
    static boolean check(int x, int y, int n) {
        for(int i = 0; i < 9; i++) {
            if(arr[x][i] == n)
                return false;
        }
        for(int i = 0; i < 9; i++) {
            if(arr[i][y] == n)
                return false;
        }
        int xPos = (x/3)*3;
        int yPos = (y/3)*3;
        for(int i = xPos; i < xPos+3; i++) {
            for(int j = yPos; j < yPos+3; j++) {
                if(arr[i][j] == n)
                    return false;
            }
        }
        return true;
    }
}