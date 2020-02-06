package com.code;

import java.util.Scanner;

public class 색종이붙이기 {
    static int[][] map = new int[10][10];
    static int[] paper = {0, 5, 5, 5, 5, 5};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++)
                map[i][j] = sc.nextInt();
        }
        dfs(0);
        System.out.println(ans == 987654321 ? -1 : ans);
    }
    static void dfs(int cnt) {
        int startR = -1;
        int startC = -1;
        out:for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if( map[i][j] == 1 ) {
                    startR = i;
                    startC = j;
                    break out;
                }
            }
        }
        if( startR == -1 && startC == -1 ) {
            ans = Math.min(ans, cnt);
            return;
        }
        int max = 5;
        while( max > 0 ) {
            boolean isOk = true;
            out: for(int i = 0; i < max; i++) {
                for(int j = 0; j < max; j++) {
                    if( startR + i >= 10 || startC + j >= 10 || map[startR+i][startC+j] == 0 ) {
                        isOk = false;
                        break out;
                    }
                }
            }
            if(isOk)
                break;
            max--;
        }
        for(int i = max; i > 0; i--) {
            if( paper[i] > 0) {
                for(int r = startR; r < startR + i; r++) {
                    for(int c = startC; c < startC + i; c++) {
                        map[r][c] = 0;
                    }
                }
                paper[i]--;
                dfs(cnt+1);
                paper[i]++;
                for(int r = startR; r < startR + i; r++) {
                    for(int c = startC; c < startC + i; c++) {
                        map[r][c] = 1;
                    }
                }
            }
        }
    }
    static int ans = 987654321;
}
