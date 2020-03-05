package net.acmicpc;

import java.util.*;

public class 말이되고픈원숭이 {
    static int W;
    static int H;
    static int K;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] horse = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    static int[][] monkey = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();
        map = new int[H][W];
        visited = new boolean[H][W][K+1];
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < K; i++) {
            visited[0][0][i] = true;
        }
        System.out.println(bfs(K));
    }
    public static int bfs(int k) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 0));

        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == H-1 && n.y == W -1) {
                return n.cnt;
            }

            for(int i = 0; i < 4; i++) {
                int dx = n.x + monkey[i][0];
                int dy = n.y + monkey[i][1];
//                if(dx >= 0 && dy >= 0 && dx < H && dy < W && map[dx][dy] != 1 && !visited[dx][dy][n.k]) {
//                    visited[dx][dy][n.cnt] = true;
//                    que.add(new Node(dx, dy, n.cnt + 1));
//                }
            }
            for(int i = 0; i < 8; i++) {
                int dx = n.x + horse[i][0];
                int dy = n.y + horse[i][1];
                if(dx >= 0 && dy >= 0 && dx < H && dy < W && map[dx][dy] != 1 && !visited[dx][dy][n.cnt+1]) {
                    visited[dx][dy][n.cnt+1] = true;
                    que.add(new Node(dx, dy, n.cnt + 1));
                }
            }
        }
        return -1;
    }
}
