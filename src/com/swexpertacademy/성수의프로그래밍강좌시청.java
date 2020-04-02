package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

public class 성수의프로그래밍강좌시청 {
    static int N;
    static int K;
    static int[] arr;
    static float result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            result = 0;
            arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            for(int i = 0; i < K; i++) {
                result = (result + arr[N-K+i])/2;
            }
            System.out.format("#%d %f\n", t, result);
        }
    }
}
