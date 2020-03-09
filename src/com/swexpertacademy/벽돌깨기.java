package com.swexpertacademy;

import java.util.*;

public class 벽돌깨기 {
    static int N;
    static int W;
    static int H;
    static int[] y;
    static int[] arr;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            W = sc.nextInt();
            H = sc.nextInt();
            map = new int[W][H];
            y = new int[N];
            arr = new int[10];
            for(int i = 0; i < W; i++) {
                arr[i] = i;
                for(int j = 0; j < H; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            subArray(0, 0);
//            System.out.println("#"+t+" ");
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
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void bfs(int[] y, int[][] map) {
        Queue<Node> que = new LinkedList();
        int x = 0;
        while(map[x][y[0]] == 0) {
            x++;
        }
        que.add(new Node(x, y[0]));
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(map[n.x][n.y] == 1) {
                que.add(new Node(y[1], 0));
                continue;
            }
            for(int i = 0; i < map[n.x][n.y]; i++) {
                for(int j = 0; j < 4; j++) {
                    int dx = n.x + move[i][0];
                    int dy = n.y + move[i][1];
                    while(dx >= 0 && dy >= 0 && dx < W && dy < H && map[dx][dy] != 0) {
                        que.add(new Node(dx, dy));
                        map[dx][dy] = 0;
                        dx += move[i][0];
                        dy += move[i][1];
                    }
                }
            }
            for(int i = 0; i < W; i++) {
                for(int j = 0; j < H; j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void subArray(int idx, int s_idx) {
        if(idx == y.length) {
            for(int i = 0; i < y.length; i++) {
                bfs(y, map);
            }
            System.out.println(Arrays.toString(y));
            return;
        }
        if(s_idx == arr.length) {
            return;
        }
        y[idx] = arr[s_idx];
        subArray(idx+1, s_idx);
        subArray(idx, s_idx+1);
    }
}
