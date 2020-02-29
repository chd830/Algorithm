package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색rere {
    static int N;
    static int M;
    static int ans = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    public static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N + 2][M + 2];
        visited = new boolean[N+2][M+2];
        /*
        dist = new int[N+2][M+2]로 하면
        0이 벽이기 때문에 배열 범위 검사를 해줄 필요가 없어진다.
         */
        for (int i = 1; i <= N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j + 1] = str.charAt(j) - '0';
            }
        }
        visited[1][1] = true;
//        dfs(1, 1, 1);
        bfs();
        System.out.println((ans == Integer.MAX_VALUE ? -1 : ans));
    }

    static void dfs(int x, int y, int cnt) {
        if(x == N && y == M) {
            if(ans > cnt) {
                ans = cnt;
            }
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if(map[nx][ny] == 1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, cnt+1);
                visited[nx][ny] = false;
            }
        }
    }

    static class Node {
        int x;
        int y;
        int count;
        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static void bfs() {
        Queue<Node> que = new LinkedList();
        que.add(new Node(1, 1, 1));
        visited[1][1] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == N && n.y == M) {
                ans = n.count;
                return;
            }
            for(int i = 0; i < 4; i++) {
                int nx = n.x + move[i][0];
                int ny = n.y + move[i][1];
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    que.add(new Node(nx, ny, n.count + 1));
                }
            }
        }
    }
}
