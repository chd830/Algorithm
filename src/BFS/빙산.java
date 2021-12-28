package BFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2573
public class 빙산 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int N;
    static int M;
    static int cnt;
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
            }
        }
        int cnt = 0;
       int ice = countIce();
        while(ice == 1) {
            melt();
            ice = countIce();
            count++;
        }
        System.out.println(ice > 1 ? count : 0);
    }

    static int count = 0;
    static void print() {
        for(int i = 0; i < N; i++)
            System.out.println(Arrays.toString(arr[i]));
        System.out.println();
    }
    // 연결확인
    static int countIce() {
        int ice = 0;
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] != 0 && !visited[i][j]) {
                    ice++;
                    Queue<Node> que = new LinkedList<>();
                    que.add(new Node(i, j));
                    visited[i][j] = true;
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        for (int d = 0; d < 4; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy] && arr[dx][dy] != 0) {
                                visited[dx][dy] = true;
                                que.add(new Node(dx, dy));
                            }
                        }
                    }
                }
            }
        }
        return ice;
    }

    // 녹이기
    static void melt() {
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] != 0) {
                    visited[i][j] = true;
                    int tmp = 0;
                    for(int d = 0; d < 4; d++) {
                        int dx = i + dir[d][0];
                        int dy = j + dir[d][1];
                        if(dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy] && arr[dx][dy] == 0) {
                            tmp++;
                        }
                    }
                    arr[i][j] = arr[i][j]-tmp < 0 ? 0 : arr[i][j] - tmp;
                }
            }
        }
    }
}