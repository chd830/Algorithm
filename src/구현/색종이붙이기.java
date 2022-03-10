package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/17136
public class 색종이붙이기 {
    static final int SIZE = 10;
    static int[] paperCount = {0, 5, 5, 5, 5, 5};
    static int[][] arr = new int[SIZE][SIZE];
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < SIZE; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0; j < SIZE; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        min = Integer.MAX_VALUE;
        recur(0, 0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
    static void recur(int x, int y, int cnt) {
        if(x == SIZE) {
            min = Math.min(min, cnt);
            return;
        }
        if(cnt >= min)
            return;
        if(y == SIZE) {
            recur(x+1, 0, cnt);
            return;
        }
        if(arr[x][y] == 1) {
            for (int paperSize = 5; paperSize > 0; paperSize--) {
                if(paperCount[paperSize] > 0 && canPaint(x, y, paperSize)) {
                    paint(x, y, paperSize, false);
                    paperCount[paperSize]--;
                    recur(x, y + 1, cnt + 1);
                    paint(x, y, paperSize, true);
                    paperCount[paperSize]++;
                }
            }
        }
        else
            recur(x, y+1, cnt);
    }
    static void paint(int x, int y, int paperSize, boolean paper) {
        for(int i = x; i < x+paperSize; i++) {
            for(int j = y; j < y+paperSize; j++) {
                arr[i][j] = paper ? 1 : 0;
            }
        }
    }
    static boolean canPaint(int x, int y, int paper) {
        if(x+paper > SIZE || y+paper > SIZE)
            return false;
        for(int i = x; i < x+paper; i++) {
            for(int j = y; j < y+paper; j++) {
                if(arr[i][j] != 1)
                    return false;
            }
        }
        return true;
    }
}
