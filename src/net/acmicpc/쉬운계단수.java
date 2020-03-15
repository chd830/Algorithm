package net.acmicpc;

import java.util.Scanner;

public class 쉬운계단수 {
    static long mod = 1000000000L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] dp = new long[N+1][10];
        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        //시작하는 수에서 숫자의 길이만큼 가면서 갈 수 있는 계단수를 더한다.
        for(int i = 2; i <= N; i++) {
            for(int j = 0; j <= 9; j++) {
                dp[i][j] = 0;
                //1작은 계단수
                if(j-1 >= 0) {
                    dp[i][j] += dp[i-1][j-1];
                }
                //1큰 계단수
                if(j+1 <= 9) {
                    dp[i][j] += dp[i-1][j+1];
                }
                dp[i][j] %= mod;
            }
        }
        long ans = 0;
        for(int i = 0; i <= 9; i++) {
            ans += dp[N][i];
        }
        ans %= mod;
        System.out.println(ans);
    }
}
