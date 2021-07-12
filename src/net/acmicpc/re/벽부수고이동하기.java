package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 2206
public class 벽부수고이동하기 {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N][M];
        count = new int[N][M];
        visited = new boolean[N][M][2];
        for(int i = 0; i < N; i++) {
            Arrays.fill(count[i], -1);
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, false, 1));
        visited[0][0][0] = true;
        count[0][0] = 1;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == N-1 && n.y == M-1) {
                System.out.println(n.cnt);
                System.exit(0);
            }
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(check(dx, dy)) {
                    if(n.wall == true) {
                        if(arr[dx][dy] == 0 && !visited[dx][dy][1]) {
                            visited[dx][dy][1] = true;
                            que.add(new Node(dx, dy, n.wall, n.cnt+1));
                        }
                    }
                    else {
                        if(arr[dx][dy] == 0 && !visited[dx][dy][0]) {
                            visited[dx][dy][0] = true;
                            que.add(new Node(dx, dy, n.wall, n.cnt+1));
                        }
                        if(arr[dx][dy] == 1 && !visited[dx][dy][1]) {
                            visited[dx][dy][1] = true;
                            que.add(new Node(dx, dy, true, n.cnt+1));
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][][] visited;
    static boolean check(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < N && dy < M;
    }
    static class Node {
        int x;
        int y;
        boolean wall;
        int cnt;

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", wall=" + wall +
                    ", cnt=" + cnt +
                    '}';
        }

        Node(int x, int y, boolean wall, int cnt) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.cnt = cnt;
        }
    }
}
/*
13 13
0100011011000
0001001010000
0000100001000
1100010101011
1111101111000
1011010001001
0100001001001
0100111010001
0101010000100
0001110100000
0000001000100
1010001000111
1001000100000
 */
