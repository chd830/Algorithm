package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 구슬탈출 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Node node) {
            if(this.x == node.x && this.y == node.y) {
                return true;
            }
            return false;
        }
    }
    static int N;
    static int M;
    static char[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Node red = null;
        Node blue = null;
        Node exit = null;
        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R') {
                    red = new Node(i, j);
                }
                if(map[i][j] == 'B') {
                    blue = new Node(i, j);
                }
                if(map[i][j] == 'O') {
                    exit = new Node(i, j);
                }
            }
        }
        recur(red, blue, exit, 0);
    }
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int recur(Node red, Node blue, Node exit, int cnt) {
        for (int i = 0; i < 4; i++) {
            int bx = blue.x + move[i][0];
            int by = blue.y + move[i][1];
            int rx = red.x + move[i][0];
            int ry = red.y + move[i][1];

            while (bx >= 0 && bx < N && by >= 0 && by < M && map[bx][by] != '#') {
                map[blue.x][blue.y] = '.';
                blue = new Node(bx, by);
                if (blue.equals(exit)) {
                    return -1;
                }
                map[bx][by] = 'B';
            }
            while (rx >= 0 && rx < N && ry >= 0 && ry < M && map[rx][ry] != '#') {
                map[red.x][red.y] = '.';
                red = new Node(rx, ry);
                if (red.equals(exit)) {
                    return cnt;
                }
                map[rx][ry] = 'R';
            }
        }
        return recur(red, blue, exit, cnt);
    }
}
