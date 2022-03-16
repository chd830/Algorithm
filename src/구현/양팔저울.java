package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2629
public class 양팔저울 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            weight[i] = Integer.parseInt(token.nextToken());
        // -값을 가질 수 있기 때문에 재귀를 쓰는 dp
        recur(0, 0);
        int K = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            int n = Integer.parseInt(token.nextToken());
            if(n > 15000)
                System.out.print("N ");
            else if(dp[N][n])
                System.out.print("Y ");
            else
                System.out.print("N ");
        }
    }
    static int N;
    static int[] weight = new int[31];
    static boolean[][] dp = new boolean[31][15001];
    static void recur(int i, int w) {
        if(i > N || dp[i][w])
            return;
        dp[i][w] = true;
        recur(i+1, w+ weight[i]);
        recur(i+1, Math.abs(w- weight[i]));
        recur(i+1, w);
    }
}
