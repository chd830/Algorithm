package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 안전영역 {
    static int N;
    static int cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    //    public static void main(String[] args) {
    public 안전영역() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        int max = 0;
        cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                max = Math.max(max, map[i][j]);
            }
        }
        for(int rain = 1; rain < max; rain++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] > rain && !visited[i][j]) {
//                        bfs(i, j, rain);
                        cnt++;
                    }
                }
            }
        }
    }

    public static void dfs(int r, int c, int height) {
        for(int k = 0; k < 4; k++) {
            int nr = r + pos[k][0];
            int nc = c + pos[k][1];
            if(nr < N && nr >= 0 && nc < N && nc >= 0 && !visited[nr][nc] && map[nr][nc] > height) {
                visited[nr][nc] = true;
                dfs(nr, nc, height);
//                bfs(nr, nc, height);
            }
        }
    }
    /*

     */
    public static void bfs(int r, int c, int height) {
        Queue<Area> q = new LinkedList<>();
        q.add(new Area(r, c));
        visited[r][c] = true;
        while(!q.isEmpty()) {
            Area a = q.poll();
            for(int i = 0; i < 4; i++) {
                int nr = r + pos[i][0];
                int nc = c + pos[i][1];
                if(nr < N && nr >= 0 && nc < N && nc >= 0 && !visited[nr][nc] && map[nr][nc] > height) {
                    visited[nr][nc] = true;
                    q.add(new Area(nr, nc));
                }
            }
        }
    }
    static class Area {
        int r, c;
        Area(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
