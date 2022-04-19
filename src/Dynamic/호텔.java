package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1106
public class 호텔 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();
        int[] dp = new int[c + 101];

        // max로 Integer.MAX_VALUE를 사용하게 되면 int의 범위를 벗어나는 문제가 생길 수 있음
        Arrays.fill(dp, 12345678);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int cost = sc.nextInt();
            int customer = sc.nextInt();
            // customer의 배수에 min값을 저장
            for (int j = customer; j < c + 101; j++) {
                dp[j] = Math.min(dp[j], dp[j - customer] + cost);
            }
        }
        // c이상의 수 중에서 min값을 찾는다.
        int result = 12345678;
        for (int i = c; i < dp.length; i++) {
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }
}
