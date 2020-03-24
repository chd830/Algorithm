package net.acmicpc;

import java.util.*;

public class 안전영역re {
    static int N;
    static int area;
    static int[][] map;
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        area = 0;
        N = sc.nextInt();
        map = new int[N][N];
        check = new boolean[N][N];
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                max = Math.max(map[i][j], max);
            }
        }
        int maxArea = 0;
        for(int i = 0; i <= max; i++) {
            for(int x = 0; x < N; x++) {
                for(int y = 0; y < N; y++) {
                    if(map[x][y] > i && !check[x][y]) {
                        bfs(x, y, i);
                        area++;
                    }
                }
            }
            for(int a = 0; a < N; a++) {
                Arrays.fill(check[a], false);
            }
//            System.out.println("paint: "+paint+", maxArea: "+maxArea);
            maxArea = Math.max(area, maxArea);
            area = 0;
        }
        System.out.println(maxArea);
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static boolean[][] check;
    public static void bfs(int x, int y, int depth) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        check[x][y] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 4; i++) {
                int nx = n.x + move[i][0];
                int ny = n.y + move[i][1];
                if(nx < N && ny < N && nx >= 0 && ny >= 0 && !check[nx][ny] && map[nx][ny] > depth) {
                    que.add(new Node(nx, ny));
                    check[nx][ny] = true;
                }
            }
        }
    }
}
