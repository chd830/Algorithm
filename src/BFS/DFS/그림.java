package BFS.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int maxArea;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];
        int cnt = 0;
        maxArea = 0;
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }
        sb.append(cnt).append("\n").append(maxArea);
        System.out.println(sb);
    }
    static int bfs(int x, int y) {
        int cnt = 1;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x ,y));
        visited[x][y] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int d = 0; d < 4; d++ ) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy] && map[dx][dy] == 1) {
                    que.add(new Node(dx, dy));
                    cnt++;
                    visited[dx][dy] = true;
                }
            }
        }
        return cnt;
    }
}
