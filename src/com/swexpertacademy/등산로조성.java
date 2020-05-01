package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등산로조성 {
    static int N;
    static int max;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int  t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            max = 0;
            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            int K = Integer.parseInt(token.nextToken());
            map = new int[N][N];
            int maxHeight = 0;
            for(int i = 0; i < N; i++) {
                token = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                    if(map[i][j] > maxHeight) {
                        maxHeight = map[i][j];
                    }
                }
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == maxHeight) {
                        visited = new boolean[N][N];
                        visited[i][j] = true;
                        dfs(i, j, K, 0, map[i][j], false);
                    }
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
    static void dfs(int x, int y, int val, int cnt, int cur, boolean check) {
        if(val < 0) {
            visited[x][y] = false;
            System.out.println();
            return;
        }
        System.out.print("("+x+", "+y+"): "+map[x][y]+"\t\t");
        max = Math.max(max, cnt);
        for(int i = 0; i < 4; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            if(isIn(dx, dy) && !visited[dx][dy]) {
                if(!check && cur < map[dx][dy]) {
                    visited[dx][dy] = true;
                    dfs(dx, dy, val-Math.abs(map[x][y] - map[dx][dy])-1, cnt+1, map[dx][dy] - map[x][y] - 1, true);
                    visited[dx][dy] = false;
                }
                else if(cur > map[dx][dy]){
                    visited[dx][dy] = true;
                    dfs(dx, dy, val, cnt+1, map[dx][dy], false);
                    visited[dx][dy] = false;
                }
            }
        }
    }
}