package com.swexpertacademy;

import java.util.Scanner;

//두 개의 숫자열
public class d2_1959 {
    public d2_1959() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] arr1 = new int[N];
            int[] arr2 = new int[M];
            for(int i = 0; i < N; i++) {
                arr1[i] = sc.nextInt();
            }
            for(int i = 0; i < M; i++) {
                arr2[i] = sc.nextInt();
            }
            int max = 0;
            for(int i = 0; i <= Math.abs(M - N); i++) {
                int sum = 0;
                if(M < N) {
                    for(int j = 0; j < M; j++) {
                        sum += arr1[j+i] * arr2[j];
                    }
                    max = Math.max(max, sum);
                }
                else {
                    for(int j = 0; j < N; j++) {
                        sum += arr1[j] * arr2[j+i];
                    }
                    max = Math.max(max, sum);
                }
            }
            System.out.println("#"+t+" "+max);
        }
    }
}
