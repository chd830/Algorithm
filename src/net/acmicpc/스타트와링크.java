package net.acmicpc;

import java.util.*;

public class 스타트와링크 {
    static int N;
    static int min;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        min = Integer.MAX_VALUE;
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        comb(0, 0);
        System.out.println(min);
    }
    static void comb(int idx, int cnt) {
        if(cnt == N/2) {
            int sum1 = 0;
            int sum2 = 0;
            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    if(visited[i] != visited[j]) continue;
                    if(visited[i]) sum1 += map[i][j] + map[j][i];
                    else sum2 += map[i][j] + map[j][i];
                }
            }
            min = Math.min(min, Math.abs(sum1-sum2));
            return;
        }
        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }
}