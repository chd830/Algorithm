package review;

import java.util.*;
import java.io.*;

public class 미로탐색 {
    static class Node {
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] maps = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                maps[i][j] = str.charAt(j) - '0';
            }
        }
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 1));
        visited[0][0] = true;
        int cnt = Integer.MAX_VALUE;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == N-1 && n.y == M-1) {
                cnt = Math.min(n.cnt, cnt);
            }
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy] && maps[dx][dy] == 1) {
                    visited[dx][dy] = true;
                    que.add(new Node(dx, dy, n.cnt+1));
                }
            }
        }
        System.out.println(cnt);
    }
}
