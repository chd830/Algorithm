package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 7576
public class 토마토 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};;
    static int[][] arr;
    static int[][] cnt;
    static int tomato;
    static int N;
    static int M;
    static Queue<Node> que;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());
        arr = new int[N][M];
        cnt = new int[N][M];
        tomato = 0;
        que = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if(arr[i][j] == -1) {
                    cnt[i][j] = -1;
                    tomato++;
                }
                if(arr[i][j] == 1) {
                    tomato++;
                    que.add(new Node(i, j));
                }
            }
        }
        System.out.println(rippen());
    }
    static int rippen() {
        if(tomato == N*M)
            return 0;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N  && dy < M && arr[dx][dy] == 0 && cnt[dx][dy] == 0) {
                    cnt[dx][dy] = cnt[n.x][n.y]+1;
                    arr[dx][dy] = 1;
                    que.add(new Node(dx, dy));
                    tomato++;
                }
            }
//            for(int i = 0; i < N; i++)
//                System.out.println(Arrays.toString(cnt[i]));
//            System.out.println();
            if(tomato == N*M) {
                return cnt[n.x][n.y]+1;
            }
        }
        return -1;
    }
}