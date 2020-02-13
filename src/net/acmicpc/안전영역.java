package net.acmicpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 안전영역 {
    static int N;
    static int cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
//    public 안전영역() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        Arrays.copyOf(map, map.length);
        visited = new boolean[N][N];
        int max = 0;
        cnt = 0;
        int area = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                max = Math.max(max, map[i][j]);
            }
        }
        for(int i = 0; i <= max; i++) {
            for(int j = 0 ; j < N; j++){
                for(int k = 0; k < N; k++) {
                    if(map[j][k] > i && !visited[j][k]) {
                        bfs(j, k, i);
                    }
                }
            }
            area = Math.max(cnt, area);
            cnt = 0;
            visited = new boolean[N][N];
        }
        System.out.println(area);
    }
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(int x, int y, int height) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        visited[x][y] = true;
        cnt++;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 4; i++) {
                int dx = n.x + pos[i][0];
                int dy = n.y + pos[i][1];
                if(dx < map.length && dx >= 0 && dy < map.length && dy >= 0 && !visited[dx][dy] && map[dx][dy] > height) {
                    que.add(new Node(dx, dy));
                    visited[dx][dy] = true;
                }
            }
        }
    }
    public static void print() {
        for(int i = 0; i < visited.length; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
    }
}
