package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14503
public class 로봇청소기 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static class Node {
        int x;
        int y;
        int d;
        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", d=" + d +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        token = new StringTokenizer(br.readLine());
        Node cur = new Node(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int count = 1;
        Queue<Node> que = new LinkedList<>();
        que.add(cur);
        visited[cur.x][cur.y] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            int d = n.d-1;
            d = d < 0 ? 3 : d;
            int check = 0;
            for(int cnt = 0; cnt < dir.length; cnt++, d--) {
                if(d < 0)
                    d = 3;
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(isIn(dx, dy) && !visited[dx][dy]) {
                    que.add(new Node(dx, dy, d));
                    visited[dx][dy] = true;
                    count++;
                    break;
                }
                else
                    check++;
            }
            //후진
            if(check == 4) {
                int dx = n.x-dir[n.d][0];
                int dy = n.y-dir[n.d][1];
                if(isIn(dx, dy)) {
                    que.add(new Node(dx, dy, n.d));
                }
                else
                    break;
            }
        }
        System.out.println(count);
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M && arr[x][y] == 0;
    }
}