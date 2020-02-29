package net.acmicpc;

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
    static int[][][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        visited = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);

            }
        }
//        for(int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dist[i]));
//        }
//        System.out.println();
        bfs();

        System.out.println((visited[N - 1][M - 1][0] != 0 ? visited[N - 1][M - 1][0] : -1));
    }

    static class Node {
        int x;
        int y;
        int z;

        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 1));
        visited[0][0][0] = 1;
        visited[0][0][1] = 1;
        while (!que.isEmpty()) {
            //벽을 뚫고가지 않는 최소값을 [left][right][0]에 저장한다.
            //벽을 뚫고가는 최소값을 [left][right][1]에 저장하고
            Node n = que.poll();
            if (n.x == N && n.y == M) {
                return;
            }
            for (int i = 0; i < 4; i++) {
                int dx = n.x + move[i][0];
                int dy = n.y + move[i][1];
                if(dx < N && dy < M && dx >= 0 && dy >= 0) {
                    if(map[dx][dy] == 0) {
                        visited[dx][dy][0] = map[n.x][n.y]+1;
                    }
                    if(map[dx][dy] == 1) {
                        visited[dx][dy][1] = map[n.x][n.y]+1;
                    }
                }
//                if (dx < N && dy < M && dx >= 0 && dy >= 0 && visited[dx][dy][0] == 0 && visited[dx][dy][1] == 0) {
//                    visited[dx][dy][0] = (char) (visited[n.left][n.right][0] - '0' + 1);
//                    que.add(new Node(dx, dy, 0));
//                    visited[dx][dy][1] = (char) Math.min((char) (visited[n.left][n.right][0] - '0' + 1), visited[n.left][n.right][1]);
//                    que.add(new Node(dx, dy, 1));
//                }
            }
            for (int k = 0; k < N; k++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(visited[k][j][0] + " ");
                }
                System.out.println();
            }
            System.out.println();
            for (int k = 0; k < N; k++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(visited[k][j][1] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
