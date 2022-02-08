package BFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/4485
public class 녹색옷입은애가젤다지 {
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
        StringBuilder sb = new StringBuilder();
        int n = 12345;
        n = Integer.parseInt(br.readLine());
        int num = 1;
        while(n != 0) {
            int[][] cnt = new int[n][n];
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    cnt[i][j] = Integer.MAX_VALUE;
                    arr[i][j] = Integer.parseInt(token.nextToken());
                }
            }
            Queue<Node> que = new LinkedList<>();
            que.add(new Node(0, 0));
            cnt[0][0] = arr[0][0];
            while(!que.isEmpty()) {
                Node node = que.poll();
                for(int d = 0; d < 4; d++) {
                    int dx = node.x + dir[d][0];
                    int dy = node.y + dir[d][1];
                    if(dx >= 0 && dy >= 0 && dx < n && dy < n) {
                        if(cnt[dx][dy] > cnt[node.x][node.y] + arr[dx][dy]) {
                            cnt[dx][dy] = cnt[node.x][node.y] + arr[dx][dy];
                            que.add(new Node(dx, dy));
                        }
                    }
                }
            }
            sb.append("Problem ").append(num++).append(": ").append(cnt[n-1][n-1]).append("\n");
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb.toString());
    }
}
