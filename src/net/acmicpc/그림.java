package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림 {
    static int N;
    static int M;
    static int area;
    static int max;
    static int cnt;
    static int[][] paints;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        paints = new int[N][M];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                paints[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(paints[i][j] == 1) {
                    area = 0;
                    bfs(i, j);
                    max = Math.max(max, area);
                    cnt++;
                }
            }
        }
        System.out.println(cnt+"\n"+max);
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        paints[x][y] = 0;
        area++;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 4; i++) {
                int dx = n.x + dir[i][0];
                int dy = n.y + dir[i][1];
                if(isIn(dx, dy)) {
                    paints[dx][dy] = 0;
                    que.add(new Node(dx, dy));
                    area++;
                }
            }
        }
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M && paints[x][y] == 1;
    }
}
