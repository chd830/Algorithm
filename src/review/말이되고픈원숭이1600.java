package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//삼차원배열사용
public class 말이되고픈원숭이1600 {
    static class Node {
        int x;
        int y;
        int cnt;
        int wall;
        Node(int x, int y, int cnt, int wall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.wall = wall;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cnt=" + cnt +
                    ", wall=" + wall +
                    '}';
        }
    }
    static int H;
    static int W;
    static int[][] monkey = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] horse = {{2, 1}, {1, 2}, {1, -2}, {2, -1}, {-1, -2}, {-1, 2}, {-2, 1}, {-2, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        W = Integer.parseInt(token.nextToken());
        H = Integer.parseInt(token.nextToken());
        int[][] map = new int[H][W];
        for(int i = 0; i < H; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        boolean[][][] visited = new boolean[H][W][K+1];
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == H-1 && n.y == W-1) {
                System.out.println(n.cnt);
                System.exit(0);
            }
            for(int d = 0; d < 8; d++) {
                int dx = n.x + horse[d][0];
                int dy = n.y + horse[d][1];
                if(isIn(dx, dy) && n.wall+1 <= K && !visited[dx][dy][n.wall+1] && map[dx][dy] == 0) {
                    visited[dx][dy][n.wall+1] = true;
                    que.add(new Node(dx, dy, n.cnt+1, n.wall+1));
                }
            }
            for(int d = 0; d < 4; d++) {
                int dx = n.x + monkey[d][0];
                int dy = n.y + monkey[d][1];
                if(isIn(dx, dy) && !visited[dx][dy][n.wall] && map[dx][dy] == 0) {
                    visited[dx][dy][n.wall] = true;
                    que.add(new Node(dx, dy, n.cnt+1, n.wall));
                }
            }
        }
        System.out.println(-1);
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < H && y < W;
    }
}
