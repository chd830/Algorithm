package BFS.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();
        for(int test_case = 0; test_case < T; test_case++) {
            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            int K = Integer.parseInt(token.nextToken());
            map = new int[N][M];
            for (int k = 0; k < K; k++) {
                token = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                map[a][b] = 1;
            }
            boolean[][] visited = new boolean[N][M];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        cnt++;
                        Queue<Node> que = new LinkedList<>();
                        que.add(new Node(i, j));
                        while (!que.isEmpty()) {
                            Node n = que.poll();
                            for (int d = 0; d < 4; d++) {
                                int dx = n.x + dir[d][0];
                                int dy = n.y + dir[d][1];
                                if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] == 1 && !visited[dx][dy]) {
                                    visited[dx][dy] = true;
                                    que.add(new Node(dx, dy));
                                }
                            }
                        }
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    static int N;
    static int M;
    static int[][] map;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
