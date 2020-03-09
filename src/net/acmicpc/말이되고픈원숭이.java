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
        //말처럼 움직인 횟수
        int horseCnt;
        Node(int x, int y, int horseCnt, int cnt) {
            this.x = x;
            this.y = y;
            this.horseCnt = horseCnt;
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
        System.out.println(bfs());
    }
    public static int bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            int dx = n.x;
            int dy = n.y;
            if(dx == H-1 && dy == W-1) {
                return n.cnt;
            }
            for(int i = 0; i < 4; i++) {
                dx = n.x + monkey[i][0];
                dy = n.y + monkey[i][1];
                if(dx >= 0 && dy >= 0 && dx < H && dy < W && !visited[dx][dy][n.horseCnt] && map[dx][dy] != 1) {
                    que.add(new Node(dx, dy, n.horseCnt, n.cnt+1));
                    visited[dx][dy][n.horseCnt] = true;
                }
            }
            for(int i = 0; i < 8; i++) {
                dx = n.x + horse[i][0];
                dy = n.y + horse[i][1];
                if(dx >= 0 && dy >= 0 && dx < H && dy < W && n.horseCnt < K && !visited[dx][dy][n.horseCnt+1] && map[dx][dy] != 1) {
                    que.add(new Node(dx, dy, n.horseCnt+1, n.cnt+1));
                    visited[dx][dy][n.horseCnt+1] = true;
                }
            }
        }
        return -1;
    }
}
