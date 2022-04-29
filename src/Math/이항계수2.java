package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이항계수2 {
    public static final int div = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        dp = new int[n+1][c+1];
        System.out.println(memoization(n, c));
    }
    static int[][] dp;
    static int memoization(int N, int K) {
        if(dp[N][K] > 0)
            return dp[N][K];
        if(N == K || K == 0)
            return dp[N][K] = 1;
        return dp[N][K] = (memoization(N-1, K-1)+memoization(N-1, K))%div;
    }
}