package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N+1];
        int[] dp = new int[N+1];
        for(int i = 1 ; i <= N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = a[1];
        if (N >= 2) {
            dp[2] = dp[1] + a[2];
        }
        for(int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-2] + a[i], a[i-1]+a[i]+dp[i-3]);
        }
        System.out.println(dp[N]);
    }
}
