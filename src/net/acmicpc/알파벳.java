package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 알파벳 {
    static int max;
    static int[] alph;
    static int[][] cnt;
    static char[][] map;
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max = 0;
        alph = new int[26];
        int N = sc.nextInt();
        int M = sc.nextInt();
        map = new char[N][M];
        cnt = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }
        cnt[0][0] = 1;
        alph[map[0][0]-65] = 1;
//        bfs();
        dfs(0, 0);
        print();
    }

    public static void print() {
        for(int i = 0; i < cnt.length; i++) {
            for(int j = 0; j < cnt[0].length; j++) {
                System.out.print(cnt[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        alph[map[0][0] - 65]++;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 4; i++) {
                int dx = n.x + move[i][0];
                int dy = n.y + move[i][1];
                if(dx >= 0 && dy >= 0 && dx < map.length && dy < map[0].length && alph[map[dx][dy]-65] == 0) {
                    alph[map[n.x][n.y] - 65]++;
                    cnt[dx][dy] = cnt[n.x][n.y]+1;
                    que.add(new Node(dx, dy));
                }
            }
        }
    }

    public static void dfs(int x, int y) {
        if(x >= map.length && y >= map[0].length) {
            return;
        }
        for(int i = 0; i < 4; i++) {
            int dx = x + move[i][0];
            int dy = y + move[i][1];
            if(dx >= 0 && dy >= 0 && dx < map.length && dy < map[0].length && alph[map[dx][dy] - 65] < 1) {
                alph[map[dx][dy] - 65]++;
                cnt[dx][dy] = cnt[x][y]+1;
                print();
                dfs(dx, dy);
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