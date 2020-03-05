package net.acmicpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 유기농배추 {
    static int N;
    static int M;
    static int K;
    static int[][] arr;
    static int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();
            arr = new int[N][M];
            visited = new boolean[N][M];
            Queue<Node> que = new LinkedList<>();
            int cnt = 0;
            for (int i = 0; i < K; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[b][a] = 1;
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(arr[i][j] == 1 && !visited[i][j]) {
                        cnt++;
                        que.add(new Node(i, j));
                        while (!que.isEmpty()) {
                            Node n = que.poll();
                            visited[n.x][n.y] = true;
                            for (int k = 0; k < 4; k++) {
                                int dx = n.x + pos[k][0];
                                int dy = n.y + pos[k][1];
                                if (dx < N && dy < M && dx >= 0 && dy >= 0 && !visited[dx][dy] && arr[dx][dy] == 1) {
                                    que.add(new Node(dx, dy));
                                    visited[dx][dy] = true;
                                }
                            }
                        }
//                        for(int k = 0; k < W; k++) {
//                            System.out.println(Arrays.toString(visited[k]));
//                        }
//                        System.out.println();
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
