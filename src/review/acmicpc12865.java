package review;

import java.util.*;
import java.io.*;

// 평범한 배낭
public class acmicpc12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[] val = new int[N];
        int[] weight = new int[N];
        int[][] dp = new int[N+1][K+1];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(token.nextToken());
            val[i] = Integer.parseInt(token.nextToken());
        }
        int max = 0;
        // 행
        for(int i = 1; i <= N; i++) {
            // 열. 무게
            for(int j = 1; j <= K; j++) {
                // 현재 위치의 무게가 정해진 값보다 가벼울 때
                if(j >= weight[i-1]) {
                    // 현재 위치의 무게가 없을 때의 값에 현재 값을 더하거나 이전의 값 중 큰 값을 구한다.
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-weight[i-1]], dp[i-1][j]);
                }
                // 현재 위치의 무게가 정해진 값보다 무거울 때
                else {
                    // 같은 무게였을 때 값이 더 크다.
                    dp[i][j] = dp[i-1][j];
                }
                max = Math.max(max, dp[i][j]);
            }
//            print(dp);
        }
        System.out.println(max);
    }
    static void print(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
}