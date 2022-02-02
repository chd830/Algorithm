package BFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/7576
public class 토마토 {
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
        int M = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());
        int[][] arr = new int[N][M];
        Queue<Node> que = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if(arr[i][j] == 1) {
                    que.add(new Node(i, j));
                    cnt++;
                }
                else if(arr[i][j] != 0)
                    cnt++;
            }
        }
        int time = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            time++;
            for(int i = 0; i < size; i++){
                Node n = que.poll();
                for (int d = 0; d < 4; d++) {
                    int dx = n.x + dir[d][0];
                    int dy = n.y + dir[d][1];
                    if (dx >= 0 && dy >= 0 && dx < N && dy < M && arr[dx][dy] == 0) {
                        que.add(new Node(dx, dy));
                        arr[dx][dy] = 1;
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt == N*M ? time-1 : -1);
    }
}
