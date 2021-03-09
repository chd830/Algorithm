package review;

import java.util.*;
import java.io.*;

// 동전 2
public class acmicpc2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[] coins = new int[N+1];
        int[] dp = new int[K+1];
        for(int i = 1; i <= N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = coins[i]; j <= K; j++) {
//                System.out.println(j+"\t"+(j-coins[i]));
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }
        System.out.println(dp[K] == 100001 ? -1 : dp[K]);
    }
}
