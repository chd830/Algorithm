package review;

import java.util.*;
import java.io.*;

// 색종이 만들기
public class acmicpc2630 {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        recur(0, 0, N);
    }
    static boolean check(int x, int y, int size) {
        int first = arr[x][y];
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(arr[i][j] == first) {
                    return false;
                }
            }
        }
        if(first == 0) {
            white++;
        }
        else {
            blue++;
        }
        return true;
    }
    static int blue = 0;
    static int white = 0;
    static void recur(int x, int y, int size) {
        if(size == 1) {
            if(arr[x][y] == 1) {
                blue++;
            }
            else {
                white++;
            }
            return;
        }
        if(check(x, y, size)) {
            return;
        }
        recur(x, y, size/2);
        recur(x+size/2, y, size/2);
        recur(x, y+size/2, size/2);
        recur(x+size/2, y+size/2, size/2);
    }
}