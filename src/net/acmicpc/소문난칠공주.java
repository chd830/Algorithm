package net.acmicpc;

import java.util.Scanner;

public class 소문난칠공주 {
    static int ans, cnt;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static char[][] array;
    static boolean[][] map;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        array = new char[5][5];

        for (int i = 0; i < 5; i++) {
            array[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < 25; i++) {
            visited = new boolean[25];
            map = new boolean[5][5];
            dfs(i, 1, 0);
        }
        System.out.println(ans);
    }
    public static void dfs(int n, int cnt, int s) {
        if (array[n / 5][n % 5] == 'S') {
            ++s;
        }

        visited[n] = true;
        map[n / 5][n % 5] = true;

        if (7 == cnt) {
            if (s >= 4) {
                find();
            }
        } else {
            for (int i = n + 1; i < 25; i++) {
                if (!visited[i]) {
                    dfs(i, cnt + 1, s);
                }
            }
        }
        // backtracking
        visited[n] = false;
        map[n / 5][n % 5] = false;
    }

    public static void find() {
        for (int i = 0; i < 25; i++) {
            if (visited[i]) {
                int y = i / 5;
                int x = i % 5;

                boolean[][] visited = new boolean[5][5];
                visited[y][x] = true;
                cnt = 1;
                isComponent(y, x, visited);
                return;
            }
        }
    }

    public static void isComponent(int y, int x, boolean[][] checked) {
        if (7 == cnt) {
            ++ans;
        } else {
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + y;
                int nx = dx[i] + x;

                if (0 <= ny && ny < 5 && 0 <= nx && nx < 5) {
                    if (map[ny][nx] && !checked[ny][nx]) {
                        checked[ny][nx] = true;
                        ++cnt;
                        isComponent(ny, nx, checked);
                    }
                }
            }
        }
    }
}
