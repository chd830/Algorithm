package com.swexpertacademy;

import java.util.Scanner;

public class 수지의수지맞는여행 {
    static int R;
    static int C;
    static int max;
    static int[] alph;
    static char[][] arr;
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            max = 0;
            R = sc.nextInt();
            C = sc.nextInt();
            alph = new int[26];
            arr = new char[R][C];
            for(int i = 0; i < R; i++) {
                String str = sc.next();
                for(int j = 0; j < C; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
            alph[arr[0][0] - 65]++;
            dfs(0, 0, 1);
            System.out.println("#"+t+" "+(max+1));
        }
    }
    public static void dfs(int x, int y, int cnt) {
        if(x >= R && y <= C) {
            return;
        }
        for(int i = 0; i < 4; i++) {
            int dx = x + move[i][0];
            int dy = y + move[i][1];
            if(dx >= 0 && dy >= 0 && dx < R && dy < C && alph[arr[dx][dy]-65] == 0) {
                alph[arr[dx][dy]-65]++;
                max = Math.max(cnt, max);
                dfs(dx, dy, cnt+1);
                alph[arr[dx][dy]-65]--;
            }
        }
    }
}
