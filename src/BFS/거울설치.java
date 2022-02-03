package BFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2151
public class 거울설치 {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int dir;
        int mirror;

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    ", mirror=" + mirror +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.mirror-o.mirror;
        }

        Node(int x, int y, int dir, int mirror) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirror = mirror;
        }
    }
    static int N;
    static char[][] arr;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        Node start = null;
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == '#')
                    start = new Node(i, j, 0, 0);
            }
        }
        visited = new boolean[N][N][4];
        min = Integer.MAX_VALUE;
        bfs(start);
    }
    static boolean isIn(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < N && dy < N;
    }
    static int min;
    static boolean[][][] visited;
    static void bfs(Node start) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        for(int d = 0; d < 4; d++) {
            que.add(new Node(start.x, start.y, d, 0));
        }
        while(!que.isEmpty()) {
            Node n = que.poll();
            int dx = n.x;
            int dy = n.y;
            int mirror = n.mirror;
            int d = n.dir;
            if(visited[dx][dy][d])
                continue;
            visited[dx][dy][d] = true;
            if(arr[dx][dy] == '#' && !(dx == start.x && dy == start.y)) {
                System.out.println(mirror);
                return;
            }
            dx += dir[d][0];
            dy += dir[d][1];
            if(!isIn(dx, dy) || arr[dx][dy] == '*')
                continue;
            if(arr[dx][dy] == '!') {
                switch (d) {
                    case 0: case 1:
                        que.add(new Node(dx, dy, 2, mirror+1));
                        que.add(new Node(dx, dy, 3, mirror+1));
                        break;
                    case 2: case 3:
                        que.add(new Node(dx, dy, 0, mirror+1));
                        que.add(new Node(dx, dy, 1, mirror+1));
                        break;
                }
            }
            que.add(new Node(dx, dy, d, mirror));
        }
    }
}