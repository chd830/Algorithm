package BFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14940
public class 쉬운최단거리 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] arr = new int[N][M];
        Node start = null;
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if(arr[i][j] == 2) {
                    arr[i][j] = 0;
                    visited[i][j] = true;
                    start = new Node(i, j);
                }
            }
        }
        Queue<Node> que = new LinkedList<>();
        que.add(start);
        int time = 0;
        while(!que.isEmpty()) {
            time++;
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Node n = que.poll();
                for(int d = 0; d < 4; d++) {
                    int dx = n.x + dir[d][0];
                    int dy = n.y + dir[d][1];
                    if(dx >= 0 && dy >= 0 && dx < N && dy < M && arr[dx][dy] == 1 && !visited[dx][dy]) {
                        que.add(new Node(dx, dy));
                        visited[dx][dy] = true;
                        arr[dx][dy] = time;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && arr[i][j] == 1)
                    arr[i][j] = -1;
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++)
                sb.append(arr[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
/*
15 15
2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
1 1 1 1 1 1 1 1 1 1 0 1 0 1 1
 */