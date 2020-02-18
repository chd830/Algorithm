package net.acmicpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
이 케이스에서 18이 답이 나와야 함.
6 5
00000
11110
00000
01111
01111
00010
 */
public class 벽부수고이동하기 {
    static int N;
    static int M;
    static char[][] map;
    static int[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        visited = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }
//        for(int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println();
        bfs();

        System.out.println((visited[N-1][M-1] != 0 ? visited[N-1][M-1] : -1));
    }
    static class Node {
        int x;
        int y;
        int w;
        Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 1));
        visited[0][0] = 1;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == N && n.y == M) {
                return;
            }
            for(int i = 0; i < 4; i++) {
                int dx = n.x + move[i][0];
                int dy = n.y + move[i][1];
                if(dx < N && dy < M && dx >= 0 && dy >= 0 && visited[dx][dy] == 0) {
                    if(n.w > 0 && map[dx][dy] == '1') {
                        que.add(new Node(dx, dy, n.w-1));
                        visited[dx][dy] = visited[n.x][n.y]+1;
                    }
                    if(map[dx][dy] == '0') {
                        que.add(new Node(dx, dy, n.w));
                        visited[dx][dy] = visited[n.x][n.y] + 1;
                    }
                }
            }
            for(int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(visited[i]));
            }
            System.out.println();
        }
    }
}
