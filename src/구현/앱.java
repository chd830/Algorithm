package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/7579
public class 앱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[] memory = new int[N];
        int[] value = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(token.nextToken());
        }
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(token.nextToken());
        }
        int[][] dp = new int[N+1][100001];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= 100000; j++) {
                if(j >= value[i-1])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-value[i-1]]+memory[i-1]);
                else
                    dp[i][j] = dp[i-1][j];
                if(dp[i][j] >= M)
                    min = Math.min(min, j);
            }
        }
        System.out.println(min);
    }
}
