package DFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14502
public class 연구소 {
    static int N;
    static int M;
    static int max;
    static int wall;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if(arr[i][j] == 1)
                    wall++;
            }
        }
        dfs(0, 0);
        System.out.println(max);
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static void dfs(int idx, int count) {
        if(count == 3) {

            // 안전영역의 개수 세기
            boolean[][] visited = new boolean[N][M];
            Queue<Node> que = new LinkedList<>();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(arr[i][j] == 2) {
                        visited[i][j] = true;
                        que.add(new Node(i, j));
                    }
                }
            }
            int cnt = que.size();
            while(!que.isEmpty()) {
                Node n = que.poll();
                for(int d = 0; d < 4; d++) {
                    int dx = n.x + dir[d][0];
                    int dy = n.y + dir[d][1];
                    if(dx >=0 && dy >= 0 && dx < N && dy < M && arr[dx][dy] != 1 && !visited[dx][dy]) {
                        visited[dx][dy] = true;
                        que.add(new Node(dx, dy));
                        cnt++;
                    }
                }
            }
            max = Math.max(max, N*M-wall-3-cnt);
            return;
        }
        for(int i = idx; i < N*M; i++) {
            int x = i/M;
            int y = i%M;
            if(arr[x][y] == 0) {
                arr[x][y] = 1;
                dfs(idx+1, count+1);
                arr[x][y] = 0;
            }
        }
    }
}
