package net.acmicpc;

import java.util.Scanner;

public class 평범한배낭 {
    static int N;
    static int K;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        Item[] items = new Item[N+1];
        max = 0;
        for(int i = 1; i <= N; i++) {
            items[i] = new Item(sc.nextInt(), sc.nextInt());
        }
        //각각의 행이 무게를 의미함.
        int[][] table = new int[N+1][K+1];
        for(int i = 1; i < table.length; i++) {
            for(int j = 1; j < table[i].length; j++) {
                if(items[i].weight > j) {
                    table[i][j] = table[i-1][j];
                }
                else {
                    table[i][j] = Math.max(items[i].profit+table[i-1][j-items[i].weight], table[i-1][j]);
                }
            }
        }
//        for(int i = 1; i <= N; i++) {
//            for(int j = 1; j  <= K; j++) {
//                System.out.print(table[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(table[N][K]);
    }

    static class Item {
        int weight;
        int profit;
        Item(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
        }
    }
//    static void knapsack(int pos, int capacity, int value) {
//        if(pos == N && capacity >= 0) {
//            max = Math.max(value, max);
//            return;
//        }
//        if(capacity < 0) {
//            return;
//        }
//        knapsack(pos+1, capacity-weight[pos], value + items[pos]);
//        knapsack(pos+1, capacity, value);
//    }
}
