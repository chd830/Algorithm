package com.swexpertacademy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 파핑파핑지뢰찾기 {
    static int N;
    static char[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            cnt = 0;
            N = sc.nextInt();
            map = new char[N][N];
            for(int i = 0; i < N; i++) {
                String str = sc.next();
                for(int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == '.' && countMine(i, j) == '0') {
                        bfs(i, j);
                    }
                }
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == '.') {
                        bfs(i, j);
                    }
                }
            }
            System.out.println("#"+t+" "+cnt);
        }
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int cnt;
    static int[][] dir = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        cnt++;
        map[x][y] = (char) countMine(x, y);
        if(map[x][y] != '0') {
            return;
        }
        que.add(new Node(x, y));
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 8; i++) {
                int dx = n.x + dir[i][0];
                int dy = n.y + dir[i][1];
                if(isIn(dx, dy) && map[dx][dy] == '.') {
                    map[dx][dy] = (char) countMine(dx, dy);
                    if(map[dx][dy] == '0') {
                        que.add(new Node(dx, dy));
                    }
                }
            }
        }
    }
    static int countMine(int x, int y) {
        int cnt = 0;
        for(int i = 0 ; i < 8; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            if(isIn(dx, dy) && map[dx][dy] == '*') {
                cnt++;
            }
        }
        return cnt+48;
    }
    static boolean isIn(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < N & dy < N;
    }
}
