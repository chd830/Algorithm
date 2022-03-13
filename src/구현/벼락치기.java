package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14728
public class 벼락치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[] grade = new int[N];
        int[] time = new int[N];
        int[][] dp = new int[N+1][K+1];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            grade[i] = Integer.parseInt(token.nextToken());
            time[i] = Integer.parseInt(token.nextToken());
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= K; j++) {
                if(j >= grade[i-1])
                    dp[i][j] = Math.max(dp[i-1][j], time[i-1]+dp[i-1][j-grade[i-1]]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(dp[N][K]);
    }
}
