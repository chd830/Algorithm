package net.acmicpc;

import java.util.Scanner;

public class 평범한배낭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] weight = new int[N];
        int[] value = new int[N];
        int K = sc.nextInt();
        int max = 0;
        for(int i = 0; i < N; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        for(int i = 0; i < 1 << N; i++) {
            int sum = 0;
            int limit = 0;
            for(int j = 0; j < N; j++) {
                if((i&1<<j) > 0) {
                    sum += value[j];
                    limit += weight[j];
                }
            }
            if(limit <= K) {
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}
