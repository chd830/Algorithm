package BFS;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/6087
public class 레이저통신 {

    private static int w, h;
    private static char[][] map;
    private static int[][] visit;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static Node start;
    private static Node end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        visit = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(visit[i], w * h);
        }
        boolean flag = false;
        for (int i = 0; i < h; i++) { // 입력
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'C') {
                    if (flag) end = new Node(i, j, 0, 4);
                    else {
                        start = new Node(i, j, 0, 4);
                        flag = true;
                    }
                }
            }
        }
        int answer = bfs();
        System.out.println(answer);
    }

    private static int bfs() {
        Queue<Node> que = new PriorityQueue<>();
        visit[start.x][start.y] = 0;
        que.add(start);
        Node n;

        while (!que.isEmpty()) {
            n = que.poll();
            if (n.x == end.x && n.y == end.y)
                return n.cost;
            for (int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if (!isValid(dx, dy) || map[dx][dy] == '*')
                    continue;
                if (n.dir == d || n.dir == 4) {
                    if (visit[dx][dy] >= n.cost) {
                        visit[dx][dy] = n.cost;
                        que.add(new Node(dx, dy, n.cost, d));
                    }
                } else {
                    if (visit[dx][dy] >= n.cost + 1) {
                        visit[dx][dy] = n.cost + 1;
                        que.add(new Node(dx, dy, n.cost + 1, d));
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= h || y >= w) return false;
        return true;
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int cost;
    int dir;

    public Node(int x, int y, int cost, int dir) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
}