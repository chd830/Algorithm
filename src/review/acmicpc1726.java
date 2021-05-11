package review;

import java.util.*;
import java.io.*;

// 로봇
public class acmicpc1726 {
    static class Node {
        int x;
        int y;
        int d;
        int val;
        Node(int x, int y, int d, int val) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", d=" + d +
                    ", val=" + val +
                    '}';
        }
    }
    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][4];
        Queue<Node> que = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        token = new StringTokenizer(br.readLine());
        Node start = new Node(Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1, 0);
        token = new StringTokenizer(br.readLine());
        Node end = new Node(Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1, 0);
        que.add(start);
        visited[start.x][start.y][start.d] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            System.out.println("CUR: "+n);
             if(n.x == end.x && n.y == end.y && n.d == end.d) {
                System.out.println(n.val);
                break;
            }
            for(int i = 1; i < 4; i++) {
                int dx = n.x + dir[n.d][0]*i;
                int dy = n.y + dir[n.d][1]*i;
                Node s = new Node(dx, dy, n.d, n.val+1);
                if(check(s)) {
                    que.add(s);
                    visited[dx][dy][n.d] = true;
                }
                else {
                    break;
                }
            }
            int left = 0, right = 0, opposite = 0;
            Node l, r, o;
            switch (n.d) {
                case 0: case 1:
                    left = 2;
                    right = 3;
                    opposite = n.d == 0 ? 1 : 0;
                    break;
                case 2: case 3:
                    left = 1;
                    right = 0;
                    opposite = n.d == 2 ? 3 : 2;
                    break;
            }

            l = new Node(n.x, n.y, left, n.val+1);
            r = new Node(n.x, n.y, right, n.val+1);
            o = new Node(n.x, n.y, opposite, n.val+2);

            if(check(l)) {
                que.add(l);
                visited[l.x][l.y][l.d] = true;
            }
            if(check(r)) {
                que.add(r);
                visited[r.x][r.y][r.d] = true;
            }
            if(check(o)) {
                que.add(o);
                visited[n.x][n.y][o.d] = true;
            }
        }
    }

    static boolean check(Node n) {
        return n.x >= 0 && n.y >= 0 && n.x < N && n.y < M && map[n.x][n.y] == 0 && !visited[n.x][n.y][n.d];
    }
}
