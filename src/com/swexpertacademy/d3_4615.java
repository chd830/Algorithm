package com.swexpertacademy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//재미있는 오셀로 게임
public class d3_4615 {
    static int[][] arr;
    static int[][] pos = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            arr = new int[N+1][N+1];
            for(int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[a][b] = sc.nextInt();

            }
            System.out.println("#"+t+" ");
        }
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 8; i++) {
                int dx = n.x + pos[i][0];
                int dy = n.y + pos[i][1];
                if(dx <= N && dy <= N && dx >= 0 && dy >= 0 && arr[dx][dy] == arr[x][y]) {
                    que.add(new Node(dx, dy));
                }
            }
        }
    }
    static void print() {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
