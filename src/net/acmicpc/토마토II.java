package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토II {
    static int N;
    static int M;
    static int H;
    static int[][][] box;
    static int[][] pos = {{1, 0, 0},{-1, 0, 0}, {0, 1, 0}, {0, 0, 1}, {0, 0, -1}, {0, -1, 0}};
    static Queue<Node> que;

    static class Node {
        int z;
        int x;
        int y;
        Node(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        box = new int[H][M][N];
        que = new LinkedList<>();
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < N; k++) {
                    box[i][j][k] = sc.nextInt();
                    if(box[i][j][k] == 1) {
                        que.add(new Node(i, j, k));
                    }
                }
            }
        }
//        print();
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int l = 0; l < 6; l++) {
                int dh = n.z + pos[l][0];
                int dx = n.x + pos[l][1];
                int dy = n.y + pos[l][2];
                if(dh < H && dx < M && dy < N && dh >= 0 && dx >= 0 && dy >= 0 && box[dh][dx][dy] != -1 && box[dh][dx][dy] == 0) {
                    box[dh][dx][dy] = box[n.z][n.x][n.y] + 1;
                    que.add(new Node(dh, dx, dy));
                }
            }
        }
        print();
        int max = 0;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if(box[i][j][k] == 0) {
                        System.out.println("-1");
                        System.exit(0);
                    }
                    if(max < box[i][j][k]) {
                        max = box[i][j][k];
                    }
                }
            }
        }print();
        System.out.println(--max);
    }
    public static void print() {
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < N; k++) {
                    System.out.print(box[i][j][k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }
}
