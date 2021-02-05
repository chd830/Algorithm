package review;

import java.util.*;
import java.io.*;

public class 다리만들기 {
    static class Node {
        int x;
        int y;
        int cnt;
        int root;
        Node(int x, int y, int cnt, int root) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.root = root;
        }
    }
    static int N;
    static int min;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        min = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        int cnt = 2;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    map[i][j] = cnt;
                    Queue<Node> que = new LinkedList<>();
                    que.add(new Node(i, j, 0, map[i][j]));
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        for(int d = 0; d < 4; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(dx >= 0 && dy >= 0 && dx < N && dy < N && map[dx][dy] == 1) {
                                que.add(new Node(dx, dy, 0, map[i][j]));
                                map[dx][dy] = cnt;
                            }
                        }
                    }
                    cnt++;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] != 0) {
                    visited = new boolean[N][N];
                    bfs(i, j);
                }
            }
        }
        System.out.println(min);
    }
    static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y, 0, map[x][y]));
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < N && map[dx][dy] != n.root && n.cnt < min && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    que.add(new Node(dx, dy, n.cnt+1, n.root));
                    if(map[dx][dy] != 0) {
                        min = Math.min(min, n.cnt);
                    }
                }
            }
        }
    }
    static void print(int[][] map) {
        for(int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
}
