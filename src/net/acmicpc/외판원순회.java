package net.acmicpc;

import java.util.Scanner;

public class 외판원순회 {
    static int min;
    static int N;
    static int[] route;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        route = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            route[i] = i;
        }
        permute(new int[N], 0);
        System.out.println((min == Integer.MAX_VALUE ? 0 : min));
    }
    public static int minValue(int[] sub) {
        int min = 0;
        for(int i = 1; i < sub.length; i++) {
            if(map[sub[i-1]][sub[i]] == 0) {
                return Integer.MAX_VALUE;
            }
            min += map[sub[i-1]][sub[i]];
        }
        if(map[sub[N-1]][sub[0]] == 0) {
            return Integer.MAX_VALUE;
        }
        min += map[sub[N-1]][sub[0]];
        return min;
    }

    public static void permute(int[] sub, int idx) {
        if(idx == sub.length) {
            min = Math.min(min, minValue(sub));
            return;
        }
        for(int i = 0; i < route.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[idx] = route[i];
                permute(sub, idx+1);
                visited[i] = false;
            }
        }
    }
}
