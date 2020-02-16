package com.swexpertacademy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//정사각형방
public class d4_1861 {
    static int size;
    static int[][] map;
    static boolean[][] visited;
    static int[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            size = sc.nextInt();
            result = new int[size*size+1];
            map = new int[size][size];
            visited = new boolean[size][size];
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int max = 0;
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    result[map[i][j]] = find(i, j);
                    max = Math.max(result[map[i][j]], max);
                }
            }
            answer: for(int i = 1; i < result.length; i++) {
                if(result[i] == max) {
                    System.out.println("#"+t+" "+i+" "+result[i]);
                    break;
                }
            }
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

    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int find(int x, int y) {
        int count = 0;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        visited[x][y] = true;
        count++;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 4; i++) {
                int dx = n.x + move[i][0];
                int dy = n.y + move[i][1];
                if(dx < size && dy < size && dx >= 0 && dy >= 0 && map[n.x][n.y] + 1 == map[dx][dy]) {
                    que.add(new Node(dx, dy));
                    visited[dx][dy] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
