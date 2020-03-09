package net.acmicpc;

import java.util.*;

public class 벽부수고이동하기 {
    static int N;
    static int M;
    static int[][] map = new int[1000][1000];
    static int[][][] cnt = new int[1000][1000][2];
    static boolean[][][] visited = new boolean[1000][1000][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }
        int res = bfs();
        System.out.println(res == -1 ? -1 : res+1);
    }
    static class Node {
        int x;
        int y;
        int cnt;
        int wall;
        Node(int x, int y, int cnt, int wall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.wall = wall;
        }
    }
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 0, 0));
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == N-1 && n.y == M-1) {
                return n.cnt;
            }
            for(int i = 0; i < 4; i++) {
                int dx = n.x + move[i][0];
                int dy = n.y + move[i][1];
                if(dx >= 0 && dx < N && dy >= 0 && dy < M) {
                    if(n.wall == 1) { //벽을 지나갔을 때
                        if(map[dx][dy] == 0 && !visited[dx][dy][n.wall]) { //벽을 뚫지 않은 지점만 지나갈 수 있다.
                            visited[dx][dy][n.wall] = true;
                            que.add(new Node(dx, dy, n.cnt+1, n.wall));
                        }
                    }
                    else { //벽을 지나 가지 않았을 때
                        if(map[dx][dy] == 1 && !visited[dx][dy][n.wall+1]) { //벽을 지나갈 때
                            visited[dx][dy][n.wall+1] = true;
                            que.add(new Node(dx, dy, n.cnt+1, n.wall+1));
                        }
                        if(map[dx][dy] == 0 && !visited[dx][dy][n.wall]) { //벽이 아닐 때
                            visited[dx][dy][n.wall] = true;
                            que.add(new Node(dx, dy, n.cnt+1, n.wall));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
