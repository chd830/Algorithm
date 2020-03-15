package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 포도주시식 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] wine = new long[N+1];
        long[] dp = new long[N+1];
        for(int i = 1; i <= N; i++) {
            wine[i] = sc.nextInt();
        }
        if(N <= 2) {
            System.out.println(N == 2 ? wine[1] + wine[2] : wine[1]);
            System.exit(0);
        }
        dp[1] = wine[1];
        dp[2] = Math.max(wine[1]+wine[2], wine[2]);
        for(int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-2]+wine[i], Math.max(wine[i-1]+wine[i]+dp[i-3], dp[i-1]));
        }
        System.out.println(dp[N]);
    }
}
