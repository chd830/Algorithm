package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 2636
public class 치즈 {
    static int N;
    static int M;
    static int cnt;
    static int prev;
    static int time;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        cnt = 0;
        prev = 0;
        time = 0;
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if (arr[i][j] == 1)
                    cnt++;
            }
        }
        while (cnt != 0) {
            time++;
            prev = cnt;
            remove();
        }
        System.out.println(time);
        System.out.println(prev);
    }
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static void remove() {
        visited = new boolean[N][M];
        Queue<Node> que = new LinkedList<>();

        for(int i = 0; i < M; i++) {
            visited[0][i] = true;
            visited[N-1][i] = true;
            que.add(new Node(0, i));
            que.add(new Node(N-1, i));
        }
        for(int i = 1; i < N-1; i++) {
            visited[i][0] = true;
            visited[i][M-1] = true;
            que.add(new Node(i, 0));
            que.add(new Node(i, M-1));
        }
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(isIn(dx, dy) && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    if(arr[dx][dy] == 0)
                        que.add(new Node(dx, dy));
                    else if(arr[dx][dy] == 1)
                        arr[dx][dy] = 2;
                }
            }
        }
        cheezeToMelt();
    }
    static void cheezeToMelt() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 2) {
                    arr[i][j] = 0;
                    cnt--;
                }
            }
        }
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
