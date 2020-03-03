package net.acmicpc;

import java.util.Scanner;

public class 알파벳 {
    static int max;
    static int[] alph;
    static char[][] map;
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max = 0;
        alph = new int[26];
        int N = sc.nextInt();
        int M = sc.nextInt();
        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }
        alph[map[0][0]-65] = 1;
//        bfs();
        dfs(0, 0, 1);
        System.out.println(max+1);
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void dfs(int x, int y, int cnt) {
        if(x >= map.length && y >= map[0].length) {
            return;
        }
        for(int i = 0; i < 4; i++) {
            int dx = x + move[i][0];
            int dy = y + move[i][1];
            if(dx >= 0 && dy >= 0 && dx < map.length && dy < map[0].length && alph[map[dx][dy] - 65] < 1) {
                max = Math.max(max, cnt);
                alph[map[dx][dy] - 65]++;
                dfs(dx, dy, cnt+1);
                alph[map[dx][dy]-65]--;
            }
        }
    }
    /*
    5 5
    IEFCJ
    FHFKC
    FFALF
    HFGCF
    HMCHH

    3 6
    HFDFFB
    AJHGDH
    DGAGEH
     */
}