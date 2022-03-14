package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/17845
public class 수강과목 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[] priority = new int[K];
        int[] time = new int[K];
        for(int i = 0; i < K; i++) {
            token = new StringTokenizer(br.readLine());
            priority[i] = Integer.parseInt(token.nextToken());
            time[i] = Integer.parseInt(token.nextToken());
        }
        int[][] dp = new int[K+1][N+1];
        for(int i = 1; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                if (j >= time[i - 1])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - time[i - 1]] + priority[i - 1]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(dp[K][N]);
    }
}
