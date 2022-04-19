package Backtracking;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2239
public class 스도쿠re {
    static final int SIZE = 9;
    static int[][] arr = new int[SIZE][SIZE];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < SIZE; i++) {
            String str = br.readLine();
            for(int j = 0; j < SIZE; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        backtracking(0, 0);
    }
    static boolean backtracking(int x, int y) {
        if(y == SIZE) {
            return backtracking(x+1, 0);
        }
        if(x == SIZE) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < SIZE; i++) {
                for(int j = 0; j < SIZE; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            return true;
        }

        if(arr[x][y] == 0) {
            for(int i = 1; i < 10; i++) {
                if(check(x, y, i)) {
                    arr[x][y] = i;
                    if(backtracking(x, y + 1))
                        return true;
                    arr[x][y] = 0;
                }
            }
        }
        else
            return backtracking(x, y+1);
        return false;
    }
    static boolean check(int x, int y, int n) {
        for(int i = 0; i < SIZE; i++) {
            if(arr[x][i] == n)
                return false;
            if(arr[i][y] == n)
                return false;
        }
        int r = x/3*3;
        int c = y/3*3;
        for(int i = r; i < r+3; i++) {
            for(int j = c; j < c+3; j++) {
                if(arr[i][j] == n)
                    return false;
            }
        }
        return true;
    }
}
