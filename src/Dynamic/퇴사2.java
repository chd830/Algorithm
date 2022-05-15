package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15486
public class 퇴사2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[1500001];
        int[] price = new int[1500001];
        int[] dp = new int[1500002];
        for (int i = 1; i <= N; i++) {
            token = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(token.nextToken());
            price[i] = Integer.parseInt(token.nextToken());
        }

        int answer = 0;
        for(int i = 1; i <= N+1; i++) {
            answer = Math.max(answer, dp[i]);
            if(i+time[i] > N+1)
                continue;
            dp[i+time[i]] = Math.max(dp[i+time[i]], answer+price[i]);
        }
        System.out.println(answer);
    }
}
