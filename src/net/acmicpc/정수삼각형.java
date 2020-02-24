package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 정수삼각형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] triangle = new int[N+2][N+2];
        for(int i = 0; i < N+2; i++) {
            Arrays.fill(triangle[i], -1);
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }

        //-1이 아닐때 좌우로 방문해서 제일 큰값을 찾도록 더해야됨.
        int[][] dp = new int[N+2][N+2];
        dp[0][0] = triangle[0][0];
        for(int i = 0; i < N; i++) {
            for(int j = 0 ; j <= i; j++) {

            }
        }
    }
}
