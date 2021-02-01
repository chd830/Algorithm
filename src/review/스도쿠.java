package review;

import java.util.*;
import java.io.*;

public class 스도쿠 {
    static final int N = 9;
    static int[][] map = new int[N][N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        check(0, 0);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static boolean sudoku(int x, int y, int k) {
        // x좌표
        for(int i = 0; i < N; i++) {
            if(map[x][i] == k) {
                return false;
            }
        }
        // y좌표
        for(int i =0 ; i < N; i++) {
            if(map[i][y] == k) {
                return false;
            }
        }
        // 3*3
        int n = x/3*3;
        int m = y/3*3;
        for(int i = n; i < n+3; i++) {
            for(int j = m; j < m+3; j++) {
                if(map[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean check(int x, int y) {
        if(x == 9) {
            return true;
        }
        if(y == 9) {
            return check(x+1, 0);
        }
        if(map[x][y] != 0) {
            return check(x, y+1);
        }
        for(int i = 1; i < 10; i++) {
            if(sudoku(x, y, i)) {
                map[x][y] = i;
                if(check(x, y+1)) {
                    return true;
                }
                map[x][y] = 0;
            }
        }
        return false;
    }
}
/*
9 0 0 8 1 2 0 0 6
0 1 2 0 0 0 8 7 0
6 0 0 7 9 5 0 1 0
0 5 7 3 6 0 0 0 0
0 0 1 0 2 0 3 0 0
0 0 0 1 0 0 9 2 0
0 4 0 2 5 1 0 0 3
0 8 6 0 0 0 2 5 0
0 0 0 6 8 3 7 9 4
 */