package net.acmicpc.re;

import java.util.*;
import java.io.*;

public class 빙산 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] arr = new int[N][M];
        Queue<Node> que = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if(arr[i][j] != 0) {
                    que.add(new Node(i, j));
                }
                else
                    arr[i][j] = -1;
            }
        }
        int cnt = 0;
        while(!que.isEmpty()) {
            cnt++;
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Node n = que.poll();
                int num = 0;
                for(int d = 0; d < 4; d++) {
                    int dx = n.x + dir[d][0];
                    int dy = n.y + dir[d][1];
                    if(dx >= 0 && dy >= 0 && dx < N && dy < M) {
                        if(arr[dx][dy] == -1 && arr[n.x][n.y] > 0) {
                            num++;
                        }
                    }
                }
                arr[n.x][n.y] = arr[n.x][n.y] < num ? 0 : arr[n.x][n.y]-num;
                if(arr[n.x][n.y] > 0 )
                    que.add(new Node(n.x, n.y));
            }
            if(iceberg(arr) >= 2) {
                System.out.println(cnt);
                System.exit(0);
            }
        }
        System.out.println(0);
    }
    static void print(int[][] arr) {
        for(int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
        System.out.println();
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int iceberg(int[][] arr) {
        int cnt = 0;
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0)
                    arr[i][j] = -1;
                if(arr[i][j] != -1 && !visited[i][j]) {
                    cnt++;
                    Queue<Node> que = new LinkedList<>();
                    que.add(new Node(i, j));
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        for(int d = 0; d < 4; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(dx >= 0 && dy >= 0 && dx < arr.length && dy < arr[0].length && !visited[dx][dy] && arr[dx][dy] > 0) {
                                visited[dx][dy] = true;
                                que.add(new Node(dx, dy));
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
