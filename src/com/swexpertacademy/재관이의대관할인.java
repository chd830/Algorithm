package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

public class 재관이의대관할인 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] arr = new int[N+1];
            for(int i = 1; i <= N; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int sum = 0;
            for(int i = N, idx = 1; i >= 0; i--, idx++) {
                if(idx%3 == 0) {
                    sum += arr[i];
                    sum -= Math.min(arr[i+2], Math.min(arr[i+1], arr[i]));
                }
                else {
                    sum += arr[i];
                }
            }
            System.out.println("#"+t+" "+sum);
        }
    }
}
