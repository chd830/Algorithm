package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//3차배열사용하기..
public class 공주님을구해라 {
    static class Node {
        int x;
        int y;
        int cnt;
        int gram;
        Node(int x, int y, int cnt, int gram) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.gram = gram;
        }

        @Override
        public String toString() {
            return "("+x+", "+y+") "+cnt+" "+gram;
        }
    }
    static int N;
    static int M;
    static int T;
    static int min;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        T = Integer.parseInt(token.nextToken());
        min = Integer.MAX_VALUE;
        map = new int[N][M];
        visited = new boolean[N][M][2];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(map[n.x][n.y] == 2) {
                n.gram = 1;
            }
            if(n.cnt > T) {
                continue;
            }
            if(n.x == N-1 && n.y == M-1) {
                min = Math.min(min, n.cnt);
            }
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy][n.gram]) {
                    if(n.gram == 1 && map[dx][dy] == 1) {
                        visited[dx][dy][n.gram] = true;
                        que.add(new Node(dx, dy, n.cnt+1, n.gram));
                    }
                    else if(map[dx][dy] == 2 || map[dx][dy] == 0){
                        visited[dx][dy][n.gram] = true;
                        que.add(new Node(dx, dy, n.cnt+1, n.gram));
                    }

                }
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? "Fail" : min);
    }
}
