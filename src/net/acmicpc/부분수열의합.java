package net.acmicpc;

import java.util.Scanner;

public class 부분수열의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long S = sc.nextInt();
        int cnt = 0;
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i<(1<<N); i++) {
            long sum = 0;
            for(int j = 0; j < arr.length; j++) {
                if((i&1<<j) != 0) {
                    sum += arr[j];
                }
            }
            if(sum == S) {
                cnt++;
            }
        }
        if(S == 0) {
            cnt--;
        }
        System.out.println(cnt);
    }
}
