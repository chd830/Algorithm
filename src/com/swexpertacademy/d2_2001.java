package com.swexpertacademy;

import java.util.Scanner;

//파리 퇴치
public class d2_2001 {
//    public static void main(String[] args) {
    public d2_2001() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int max = arr[0][0];
            for(int i = 0; i <= N - M; i++) {
                for(int j = 0; j <= N - M; j++) {
                    max = Math.max(sumValue(arr, i, j, M), max);
                }
            }
            System.out.println("#"+t+" "+max);
        }
    }
    public int sumValue(int[][] arr, int x, int y, int M) {
        int sum = 0;
        for(int i = x; i < x + M; i++) {
            for(int j = y; j < y + M; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
