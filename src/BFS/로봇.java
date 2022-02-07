package BFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1726
public class 로봇 {
    static class Node {
        int x;
        int y;
        int cnt;
        int dir;
        Node(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    ", cnt=" + cnt +
                    '}';
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int N;
    static int M;
    static boolean isIn(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < N && dy < M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        int[][] arr = new int[N][M];
        boolean[][][] visited = new boolean[N][M][4];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        token = new StringTokenizer(br.readLine());
        Node start = new Node(Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1, 0);
        token = new StringTokenizer(br.readLine());
        Node end = new Node(Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1, 0);
        Queue<Node> que = new LinkedList<>();
        visited[start.x][start.y][start.dir] = true;
        que.add(start);
        while(!que.isEmpty()) {
            Node n = que.poll();
            int x = n.x;
            int y = n.y;
            int d = n.dir;
            int cnt = n.cnt;

            if(x == end.x && y == end.y && d == end.dir) {
                System.out.println(cnt);
                break;
            }
            for(int i = 1; i < 4; i++) {
                int dx = x + dir[d][0]*i;
                int dy = y + dir[d][1]*i;
                if(!isIn(dx, dy))
                    continue;
                if(arr[dx][dy] == 0) {
                    if(!visited[dx][dy][d]) {
                        visited[dx][dy][d] = true;
                        que.add(new Node(dx, dy, d, cnt+1));
                    }
                }
                else
                    break;
            }
            for(int i = 0; i < 4; i++) {
                if(d != i && !visited[x][y][i]) {
                    int turn = 1;
                    if(d == 0 && i == 1)
                        turn++;
                    else if(d == 1 && i == 0)
                        turn++;
                    else if(d == 2 && i == 3)
                        turn++;
                    else if(d == 3 && i == 2)
                        turn++;
                    visited[x][y][i] = true;
                    que.add(new Node(x, y, i, cnt+turn));
                }
            }
        }

    }
}
/*
10 10
0 1 1 1 0 0 0 0 0 1
0 0 0 0 0 1 1 1 1 1
0 0 0 0 0 1 1 1 1 1
0 1 0 0 1 1 1 1 1 1
0 0 0 1 0 0 0 1 1 1
0 1 1 1 0 0 0 0 0 1
0 0 0 1 1 0 0 0 1 1
0 1 0 1 1 1 1 0 1 1
0 0 0 1 1 1 1 1 1 1
1 1 1 1 1 1 1 0 1 1
1 9 1
9 1 3

9 12
0 0 0 0 0 0 0 0 0 0 0 1
0 1 1 1 1 0 0 1 1 1 1 0
0 0 0 0 0 0 0 1 1 1 1 0
0 1 1 1 1 0 0 1 1 1 1 0
0 0 0 0 0 0 0 0 0 0 0 0
0 1 1 1 1 0 0 1 1 1 1 0
0 1 1 1 1 0 0 0 0 0 0 0
0 1 1 1 1 0 0 1 1 1 1 0
1 0 0 0 0 0 0 0 0 0 0 0
1 1 3
9 12 3
 */