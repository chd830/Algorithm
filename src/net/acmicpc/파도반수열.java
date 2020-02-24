package net.acmicpc;

import java.util.Scanner;

public class 파도반수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[] arr = new long[100];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 2;
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            if(N <= 5) {
                System.out.println(arr[N-1]);
                continue;
            }
            for(int i = 5; i < N; i++) {
                arr[i] = arr[i-1] + arr[i-5];
            }
            System.out.println(arr[N-1]);
        }
    }
}
