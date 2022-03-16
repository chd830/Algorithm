package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/23061
public class 백남이의여행준비 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int stock = Integer.parseInt(token.nextToken());
        int bag = Integer.parseInt(token.nextToken());
        int[] weight = new int[stock];
        int[] value = new int[stock];
        int[] bags = new int[bag];
        for(int i = 0; i < stock; i++) {
            token = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(token.nextToken());
            value[i] = Integer.parseInt(token.nextToken());
        }
        int max = 0;

        for(int i = 0; i < bag; i++) {
            bags[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, bags[i]);
        }

        int[][] dp = new int[stock+1][max+1];
        for(int i = 1; i <= stock; i++) {
            for(int j = 0; j <= max; j++) {
                if(j >= weight[i-1])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]]+value[i-1]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        max = 0;
        double maxUtility = 0.0;
        int result = 0;
        for(int i = 0; i < bag; i++) {
            double utility = (double)dp[stock][bags[i]]/bags[i];
            if(maxUtility < utility) {
                result = i+1;
                maxUtility = utility;
            }
        }
        System.out.println(result);
    }
}