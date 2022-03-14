package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16493
public class 최대페이지수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] dp = new int[M+1][N+1];
        int[] date = new int[M];
        int[] page = new int[M];
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            date[i] = Integer.parseInt(token.nextToken());
            page[i] = Integer.parseInt(token.nextToken());
        }
        for(int i = 1; i <= M; i++) {
            for(int j = 0; j <= N; j++) {
                if(j >= date[i-1])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-date[i-1]]+page[i-1]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(dp[M][N]);
    }
}
