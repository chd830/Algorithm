package net.acmicpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {
    static int M;
    static int N;
    static int cnt;
    static int[][] arr;
    static int[][] check;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//    static boolean[][] visited;

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
        M = sc.nextInt();
        N = sc.nextInt();
        cnt = 0;
        /*
        -1: 토마토없음
        0: 토마토안익음
        1: 익은토마토
         */
        arr = new int[N][M];
        check = new int[N][M];
//        visited = new boolean[W][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Queue<Node> que = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 1) {
                    que.add(new Node(i, j));
                }
            }
        }
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 4; i++) {
                int dx = n.x + pos[i][0];
                int dy = n.y + pos[i][1];
                if(dx >= 0 && dx < N && dy >= 0 && dy < M && arr[dx][dy] == 0) {
                    arr[dx][dy] = arr[n.x][n.y] + 1;
                    que.add(new Node(dx, dy));
                }
            }
//            for(int j = 0; j < W; j++) {
//                System.out.println(Arrays.toString(visited[j]));
//            }
//            System.out.println();
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                max = Math.max(arr[i][j], max);
                if(arr[i][j] == 0) {
                    System.out.println("-1");
                    System.exit(0);
                }
            }
        }
        System.out.println(--max);
    }
}