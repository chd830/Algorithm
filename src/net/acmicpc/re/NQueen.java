package net.acmicpc.re;

import java.io.*;
import java.util.*;

public class NQueen {
    static int N;
    static int cnt;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        cnt = 0;
        recur(0);
    }

    static void print() {
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
    static void recur(int idx) {
        if(idx == N) {
            cnt++;
            print();
            return;
        }
        for(int i = 0; i < N; i++) {
            if(check(idx, i)) {
                map[idx][i] = 1;
                recur(idx+1);
                map[idx][i] = 0;
            }
        }
    }

    static boolean check(int r, int c) {
        //위
        for(int i = r; i >= 0; i--) {
            if(map[i][c] == 1) {
                return false;
            }
        }
        //왼쪽 위
        for(int i = 1; r >= i && c >= i; i++) {
            if(map[r-i][c-i] == 1) {
                return false;
            }
        }
        //오른쪽 위
        for(int i = 1; r >= i && c + i < N; i++) {
            if(map[r-i][c+i] == 1) {
                return false;
            }
        }
        return true;
    }
}
