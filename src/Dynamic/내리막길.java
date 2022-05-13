package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1520
public class 내리막길 {
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
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];
        for(int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1);
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        System.out.println(recur(0, 0));
    }
    static int N;
    static int M;
    static int[][] arr;
    static int[][] dp;
    static int recur(int x, int y) {
        if(x == N-1 && y == M-1)
            return 1;
        if(dp[x][y] != -1)
            return dp[x][y];
        dp[x][y] = 0;
        for(int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if (dx >= 0 && dy >= 0 && dx < N && dy < M) {
                if(arr[x][y] > arr[dx][dy])
                    dp[x][y] += recur(dx, dy);
            }
        }
        return dp[x][y];
    }
}
