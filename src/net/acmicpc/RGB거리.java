package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class RGB거리 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dp = new int[N][3];
        int[][] house = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                house[i][j] = sc.nextInt();
            }
        }
        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];
        //첫번째 행은 주어진 행과 동일하고
        for(int i = 1; i < N; i++) {
            //그 이전의 행에서 가능한 값과 현재의 값을 더해서 최소값을 구한다.
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
        }
        System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
    }
}
