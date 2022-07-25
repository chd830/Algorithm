package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1495
public class 기타리스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int start = Integer.parseInt(token.nextToken());
        int limit = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        boolean[][] dp = new boolean[N+1][limit+1];
        dp[0][start] = true;
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= limit; j++) {
                if(!dp[i-1][j])
                    continue;
                if(j-arr[i] >= 0)
                    dp[i][j-arr[i]] = true;
                if(j+arr[i] <= limit)
                    dp[i][j+arr[i]] = true;
            }
        }
        int result = -1;
        for (int j = limit; j >= 0; j--) {
            if (dp[N][j]) {
                result = j;
                break;
            }
        }
        System.out.println(result);
    }
}
