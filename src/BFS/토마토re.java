package BFS;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/7576
public class 토마토re {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());
        int[][] arr = new int[N][M];
        Queue<Node> que = new LinkedList<>();
        int tomato = 0;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if(arr[i][j] == 1) {
                    que.add(new Node(i, j));
                }
                if(arr[i][j] != 0)
                    tomato++;
            }
        }
        int time = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            time++;
            for(int i = 0; i < size; i++) {
                Node n = que.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = n.x + dir[d][0];
                    int dy = n.y + dir[d][1];
                    if (isIn(dx, dy) && arr[dx][dy] == 0) {
                        tomato++;
                        arr[dx][dy] = 1;
                        que.add(new Node(dx, dy));
                    }
                }
            }
        }
        System.out.println(tomato == N*M ? time-1 : -1);
    }
    static boolean isIn(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < N && dy < M;
    }
}