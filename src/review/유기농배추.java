package review;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(token.nextToken());
            int K = Integer.parseInt(token.nextToken());
            int[][] maps = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            for(int i = 0; i < K; i++) {
                token = new StringTokenizer(br.readLine());
                maps[Integer.parseInt(token.nextToken())][Integer.parseInt(token.nextToken())] = 1;
            }
            int cnt = 0;
            Queue<Node> que = new LinkedList<>();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(maps[i][j] == 1 && !visited[i][j]) {
                        cnt++;
                        que.add(new Node(i, j));
                        visited[i][j] = true;
                        while(!que.isEmpty()) {
                            Node n = que.poll();
                            for(int d = 0; d < dir.length; d++) {
                                int dx = n.x + dir[d][0];
                                int dy = n.y + dir[d][1];
                                if(dx >= 0 && dy >= 0 && dx < N && dy < M && maps[dx][dy] == 1 && !visited[dx][dy]) {
                                    que.add(new Node(dx, dy));
                                    visited[dx][dy] = true;
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
