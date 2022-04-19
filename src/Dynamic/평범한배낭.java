package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/12865
public class 평범한배낭 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[] val = new int[N];
        int[] weight = new int[N];
        int[][] dp = new int[N+1][K+1];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(token.nextToken());
            val[i] = Integer.parseInt(token.nextToken());
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                // 현재 위치의 무게가 정해진 값보다 가벼울 때
                if(j >= weight[i-1]) {
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-weight[i-1]], dp[i-1][j]);
                }
                else {
                    // 같은 무게였을 때 값이 더 크다.
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
