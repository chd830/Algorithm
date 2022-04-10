package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14391
public class 종이조각 {
    static int N;
    static int M;
    static int max;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        max = 0;
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        next(0, 0);
        System.out.println(max);
    }
    static void next(int idx, int sum) {
        int x = idx/M;
        int y = idx%M;
        if(idx >= N*M) {
            max = Math.max(max, sum);
            return;
        }
        if(visited[x][y]) {
            next(idx + 1, sum);
            return;
        }
        int val = arr[x][y];
        visited[x][y] = true;
        next(idx+1, sum+val);
        visited[x][y] = false;
        for(int i = 1; i < M-y; i++) {
            int dx = x;
            int dy = y+i;
            if(visited[dx][dy])
                return;
            val *= 10;
            val += arr[dx][dy];
            for(int j = 1; j <= i; j++)
                visited[dx][y+j] = true;
            next(idx+1, sum+val);
            for(int j = 1; j <= i; j++)
                visited[dx][y+j] = false;
        }
        val = arr[x][y];
        for(int i = 1; i < N-x; i++) {
            int dx = x+i;
            int dy = y;
            if(visited[dx][dy])
                return;
            val *= 10;
            val += arr[dx][dy];
            for(int j = 1; j <= i; j++)
                visited[x+j][dy] = true;
            next(idx+1, sum+val);
            for(int j = 1; j <= i; j++)
                visited[x+j][dy] = false;
        }
    }
}