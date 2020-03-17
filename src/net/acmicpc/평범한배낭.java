package net.acmicpc;

import java.util.Scanner;

public class 평범한배낭 {
    static int N;
    static int K;
    static int max;
    static int[] weight;
    static int[] items;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        weight = new int[N];
        items = new int[N];
        K = sc.nextInt();
        max = 0;
        for(int i = 0; i < N; i++) {
            weight[i] = sc.nextInt();
            items[i] = sc.nextInt();
        }
//        knapsack(0, K, 0);
        System.out.println(max);
    }

    static void knapsack(int pos, int capacity, int value) {
        if(pos == N && capacity >= 0) {
            max = Math.max(value, max);
            return;
        }
        if(capacity < 0) {
            return;
        }
        knapsack(pos+1, capacity-weight[pos], value + items[pos]);
        knapsack(pos+1, capacity, value);
    }
}
