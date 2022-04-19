package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2225
public class 합분해 {
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        int[][] dp = new int[K+1][N+1];
        Arrays.fill(dp[1], 1);
        for(int i = 1; i <= K; i++)
            dp[i][0] = 1;
        for(int i = 2; i <= K; i++) {
            for(int j = 1; j <= N; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
                dp[i][j] %= 1000000000;
            }
        }
        System.out.println(dp[K][N]);
    }
}