package BFS;

import java.util.*;
import java.io.*;

public class 벽부수고이동하기 {
    static class Node {
        int x;
        int y;
        int cnt;
        boolean wall;
        Node(int x, int y, int cnt, boolean wall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.wall = wall;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][]arr = new int[N][M];
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][][] visited = new boolean[N][M][2];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        Queue<Node> que = new LinkedList<>();
        visited[0][0][0] = true;
        int[][][] count = new int[N][M][2];
        count[0][0][0] = 1;
        que.add(new Node(0, 0, 1, false));
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == N-1 && n.y == M-1) {
                System.out.println(n.cnt);
                System.exit(0);
            }
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M) {
                    if(n.wall && arr[dx][dy] == 0 && !visited[dx][dy][1]) {
                        visited[dx][dy][1] = true;
                        que.add(new Node(dx, dy, n.cnt+1, true));
                        count[dx][dy][1] = count[n.x][n.y][1]+1;
                    }

                    if(!n.wall && arr[dx][dy] == 1 && !visited[dx][dy][1]) {
                        visited[dx][dy][1] = true;
                        que.add(new Node(dx, dy, n.cnt+1, true));
                        count[dx][dy][1] = count[n.x][n.y][0]+1;
                    }
                    if(!n.wall && arr[dx][dy] == 0 && !visited[dx][dy][0]) {
                        visited[dx][dy][0] = true;
                        que.add(new Node(dx, dy, n.cnt+1, n.wall));
                        count[dx][dy][0] = count[n.x][n.y][0]+1;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
/*
5 6
000000
011110
010000
010111
100000
 */