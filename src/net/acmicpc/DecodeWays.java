package net.acmicpc;

public class DecodeWays {
    public int numDecodings(String s) {
        //DP문제 피보나치랑 같은 방식으로 접근
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            System.out.println("first: "+first+", second: "+second);
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
            System.out.println("dp["+i+"]: "+dp[i]);
        }
        return dp[n];
    }
}
