package net.acmicpc;

import java.util.*;
import java.util.Scanner;

public class 다리만들기 {
    static class Node {
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int N;
    static int min;
    static int island;
    static int[][] map;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        island = 0;
        //각각의 섬에 숫자 부여하기
        boolean[][] visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    island++;
                    Queue<Node> que = new LinkedList();
                    que.add(new Node(i, j, 0));
                    visited[i][j] = true;
                    map[i][j] = island;
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        for(int d = 0; d < 4; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(isIn(dx, dy) && !visited[dx][dy] && map[dx][dy] == 1) {
                                map[dx][dy] = island;
                                que.add(new Node(dx, dy, 0));
                                visited[dx][dy] = true;
                            }
                        }
                    }
                }
            }
        }
        min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j =0  ;j < N; j++) {
                if(map[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(min);
    }
    static void bfs(int x, int y) {
        boolean[][] visited = new boolean[map.length][map.length];
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y, 0));
        visited[x][y] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.cnt >= min) {
                break;
            }
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(isIn(dx, dy) && !visited[dx][dy]) {
                    if(map[dx][dy] == map[x][y]) {
                        continue;
                    }
                    else if(map[dx][dy] == 0) {
                        que.add(new Node(dx, dy, n.cnt+1));
                    }
                    else if(map[dx][dy] != map[x][y]) {
                        min = Math.min(min, n.cnt);
                        return;
                    }
                }
            }
        }

    }
    static boolean isIn(int x, int y) {
        return x < N && y < N && x >= 0 && y >= 0;
    }
}
