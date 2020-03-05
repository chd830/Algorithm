package com.swexpertacademy;

import java.util.*;

public class 초콜릿과건포도 {
    static int n;
    static int m;
    static int result;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            n = sc.nextInt();
            m = sc.nextInt();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            result = dfs(0, 0, n, m);
            System.out.println("#"+t+" "+result);
        }
    }
    static int dfs(int x, int y, int w, int h) {
        if(w == 1 && h == 1) {
            return 0;
        }
        int sum = 0;
        for(int i = x; i < x+h; i++) {
            for(int j = y; j < y+w; j++) {
                sum += map[i][j];
            }
        }
        for(int i = 1; i < h; i++) {
            int sum1 = dfs(x, y, i, w);
            int sum2 = dfs(x, y+1, h-i, w);
            int sum3 = sum + sum1 + sum2;
        }
        dfs(x, y, w-1, h-1);
        return 1;
    }
}
