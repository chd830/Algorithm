package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 가장긴바이토닉수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 0);
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp1[i] < dp1[j]+1) {
                    dp1[i] = dp1[j]+1;
                }
            }
        }
        for(int i = N-1; i >= 0; i--) {
            for(int j = N-1; j > i; j--) {
                if(arr[i] > arr[j] && dp2[i] < dp2[j]+1) {
                    dp2[i] = dp2[j]+1;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp1[i]+dp2[i]);
        }
        System.out.println(max);
    }
}
