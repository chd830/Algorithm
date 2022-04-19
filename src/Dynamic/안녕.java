package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1535
public class 안녕 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] lost = new int[N];
        int[] get = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            lost[i] = Integer.parseInt(token.nextToken());
        }
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            get[i] = Integer.parseInt(token.nextToken());
        }
        int[][] dp = new int[N+1][101];
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(j > lost[i-1])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-lost[i-1]]+get[i-1]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(dp[N][100]);
    }
}
