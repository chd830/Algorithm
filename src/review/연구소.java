package review;

import java.util.*;
import java.io.*;

// 벽 세개를 세우고 바이러스가 모두 퍼졌을 때 안전영역의 최대 크기
public class 연구소 {
    static int N;
    static int M;
    static int max;
    static int[][] map;
//    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];
//        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        // 벽 놓기
        recur( 0, 0);
        // 벽 세기
        System.out.println(max);
    }

    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static class  Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int countArea(int[][] maps) {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(maps[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static void virus(int[][] maps) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(maps[i][j] == 2) {
                    boolean[][] visited = new boolean[N][M];
                    Queue<Node> que = new LinkedList<>();
                    que.add(new Node(i, j));
                    visited[i][j] = true;
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        for(int d = 0; d < 4; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(isIn(dx, dy) && !visited[dx][dy] && maps[dx][dy] == 0) {
                                que.add(new Node(dx, dy));
                                maps[dx][dy] = 2;
                                visited[dx][dy] = true;
                            }
                        }
                    }
                }
            }
        }
        max = Math.max(countArea(maps), max);
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
    static void recur(int idx, int cnt) {
        if(cnt == 3) {
            int[][] copy = new int[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    copy[i][j] = map[i][j];
                }
            }
            virus(copy);
            return;
        }
        for(int i = idx; i < N*M; i++) {
            int x = i / M;
            int y = i % M;
            if(map[x][y] == 0) {
                map[x][y] = 1;
                recur(i+1, cnt+1);
                map[x][y] = 0;
            }
        }
        // 시간초과
//        for(int i = 0; i < N; i++) {
//            for(int j = 0; j < M; j++) {
//                if(map[i][j] == 0 && !visited[i][j]) {
//                    visited[i][j] = true;
//                    map[i][j] = 1;
//                    recur(cnt+1);
//                    visited[i][j] = false;
//                    map[i][j] = 0;
//                }
//            }
//        }
    }
}
