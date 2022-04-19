package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/4781
public class 사탕가게 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken());
            // 부동소수점 문제로 double을 int형으로 바꿀 때 자릿수만큼 곱하고 0.5를 꼭 더해주어야함
            int M = (int)(Double.parseDouble(token.nextToken())*100+0.5);
            if(N == 0 && M == 0)
                break;
            int[] dp = new int[10001];
            for(int i = 1; i <= N; i++) {
                token = new StringTokenizer(br.readLine());
                int calories = Integer.parseInt(token.nextToken());
                int price = (int)(Double.parseDouble(token.nextToken())*100+0.5);
                for(int j = price; j <= M; j++)
                    dp[j] = Math.max(dp[j], dp[j-price]+calories);
            }
            System.out.println(dp[M]);
        }
    }
}
