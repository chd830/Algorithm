package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16236
public class 아기상어 {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int val;
        int dist;

        Node(int x, int y, int val, int dist) {
            this.x = x;
            this.y = y;
            this.val = val;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", val=" + val +
                    ", dist=" + dist +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist == o.dist) {
                if (this.x == o.x)
                    return Integer.compare(this.y, o.y);
                return Integer.compare(this.x, o.x);
            }
            return Integer.compare(this.dist, o.dist);
        }
    }

    static int N;
    static Node shark;
    static int[][] arr;
    static PriorityQueue<Node> que;
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int[][] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        count = new int[N][N];
        shark = null;
        que = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if (arr[i][j] == 9)
                    shark = new Node(i, j, arr[i][j], 0);
            }
        }
        arr[shark.x][shark.y] = 0;
        int size = 2;
        int cnt = 0;
        int time = 0;
        int idx = 1;
        setFish(shark.x, shark.y, size);
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.val == size)
                continue;
            time += n.dist;
            count[n.x][n.y] = idx++;
            cnt++;
            shark = new Node(n.x, n.y, 9, 0);
            arr[n.x][n.y] = 0;
            if(size == cnt) {
                size++;
                cnt = 0;
            }
            setFish(shark.x, shark.y, size);
        }
        System.out.println(time);
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
    static void setFish(int x, int y, int size) {
        que = new PriorityQueue<>();
        Queue<Node> visit = new LinkedList<>();
        visit.add(new Node(x, y, 0, 0));
        boolean[][] visited = new boolean[N][N];
        visited[x][y] = true;
        while(!visit.isEmpty()) {
            Node n = visit.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(isIn(dx, dy) && !visited[dx][dy] && arr[dx][dy] <= size) {
                    visited[dx][dy] = true;
                    visit.add(new Node(dx, dy, arr[dx][dy], n.dist+1));
                    if(arr[dx][dy] != 0 && arr[dx][dy] < size) {
                        que.add(new Node(dx, dy, arr[dx][dy], n.dist+1));
//                        que.add(new Node(dx, dy, arr[dx][dy], Math.abs(dx-shark.x)+Math.abs(dy-shark.y)));
                    }
                }
            }
        }
    }
}