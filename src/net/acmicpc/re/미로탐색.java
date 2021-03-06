package net.acmicpc.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        char[][] map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 1));
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == N-1 && n.y == M-1) {
                System.out.println(n.cnt);
                System.exit(0);
            }
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] == '1' && !visited[dx][dy]) {
                    que.add(new Node(dx, dy, n.cnt+1));
                    //방문체크가 이 위치가 아니었을 때 방문한 점을 다시 방문하는 케이스가 생겨서 메모리초과가 발생함.
                    visited[n.x][n.y] = true;
                }
            }
        }
    }
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
}
