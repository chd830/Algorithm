package net.acmicpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색re {
    static int N;
    static int M;
    static int[][] map;
    public static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N+2][M+2];
        /*
        map = new int[N+2][M+2]로 하면
        0이 벽이기 때문에 배열 범위 검사를 해줄 필요가 없어진다.
         */
        for(int i = 1; i <= N; i++) {
            String str = sc.next();
            for(int j = 0; j < M; j++) {
                map[i][j+1] = str.charAt(j) - '0';
            }
        }
        dfs(1,1);
//        bfs();
        System.out.println(map[N][M]);
        System.out.println();
        for(int i = 0; i < N+2; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
    public static void dfs(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int dx = x + move[i][0];
            int dy = y + move[i][1];
            if(dx >= 0 && dy >= 0 && map[dx][dy] == 1) {
                map[dx][dy] = map[x][y] + 1;
                dfs(dx, dy);
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
    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(1,1));

        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 4; i++) {
                int dx = n.x + move[i][0];
                int dy = n.y + move[i][1];
                if(map[dx][dy] == 1) {
                    que.add(new Node(dx, dy));
                    map[dx][dy] = map[n.x][n.y] + 1;
                }
            }
        }

    }
}
