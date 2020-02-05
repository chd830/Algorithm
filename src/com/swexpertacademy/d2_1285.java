package com.swexpertacademy;

import java.util.Scanner;

//아름이의 돌 던지기
public class d2_1285 {
//    public static void main(String[] args) {
    public d2_1285() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int result = 0;
            int min = Integer.MAX_VALUE;
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
                int distance = Math.abs(arr[i] - 0);
                if(distance < min) {
                    min = distance;
                }
                arr[i] = distance;
            }
            for(int a : arr) {
                if(a == min) {
                    result++;
                }
            }
            System.out.println("#"+t+" "+min+" "+result);
        }
    }
}
