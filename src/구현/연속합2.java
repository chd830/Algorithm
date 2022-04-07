package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/13398
public class 연속합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 연속된 몇 개의 수를 선택하여 가장 큰 합을 구하기
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[][] dp = new int[N][2];
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        int max = arr[0];
        dp[0][0] = dp[0][1] = arr[0];
        for(int i = 0; i < N; i++) {
            if(i == 0)
                continue;
            // 삭제하지 않은 경우. 이전의 값을 모두 더하거나 새로 들어온 값 저장
            dp[i][0] = Math.max(dp[i-1][0]+arr[i], arr[i]);
            // 삭제한 경우.
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+arr[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(max);
    }
}
