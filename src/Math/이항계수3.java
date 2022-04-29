package Math;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11401
public class 이항계수3 {
    static final long div = 1000000007;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        long parent = factorial(N);
        long child = factorial(K)*factorial(N-K)%div;
        // N! * (N-K)!의 역원
        System.out.println(parent*pow(child, div-2)%div);
    }
    static long factorial(int N) {
        long answer = 1;
        while(N > 1) {
            answer = answer*N%div;
            N--;
        }
        return answer;
    }
    // 밑 base, 지수 expo
    // 역원을 구함
    static long pow(long base, long expo) {
        if(expo == 1)
            return base%div;
        long tmp = pow(base, expo/2);
        if(expo%2 == 1)
            return (tmp*tmp%div)*base%div;
        return tmp*tmp%div;
    }
    // dp를 사용하면 메모리초과 발생
    static long memoization(int N, int K) {
        if(dp[N][K] > 0)
            return dp[N][K];
        if(N == 0 || N == 1 || K == 0 || K == 1)
            return dp[N][K] = 1;
        return dp[N][K] = (memoization(N-1, K-1)+memoization(N-1, K))%div;
    }
}
