package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추1012 {
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(token.nextToken());
            int K = Integer.parseInt(token.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            for(int k = 0; k < K; k++) {
                token = new StringTokenizer(br.readLine());
                map[Integer.parseInt(token.nextToken())][Integer.parseInt(token.nextToken())] = 1;
            }
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        searchCabbage(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    static void searchCabbage(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        visited[x][y] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < map.length && dy < map[0].length && !visited[dx][dy] && map[dx][dy] == 1) {
                    visited[dx][dy] = true;
                    que.add(new Node(dx, dy));
                }
            }
        }
    }
}
