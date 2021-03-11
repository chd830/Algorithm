package review;

import java.util.*;
import java.io.*;

// 퇴사
public class acmicpc14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] date = new int[N+1];
        int[] val = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer token = null;
        for(int i = 1; i <= N; i++) {
            token = new StringTokenizer(br.readLine());
            date[i] = Integer.parseInt(token.nextToken());
            val[i] = Integer.parseInt(token.nextToken());
            dp[i] = val[i];
        }
        // 구할 수 있는 최대 이익
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i - j >= date[j]) {
                    dp[i] = Math.max(val[i] + dp[j], dp[i]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }

        // 정해진 날짜 안에 구할 수 있는 최대이익
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (i + date[i] <= N + 1) {
                if (max < dp[i]) {
                    max = dp[i];
                }
            }
        }
        System.out.println(max);
    }
}