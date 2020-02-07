package net.acmicpc;

import java.util.Scanner;

public class 블랙잭 {
//    public static void main(String[] args) {
    public 블랙잭() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        long max = 0;
        combination(0, 0);
        System.out.println(max);
    }
    static int[] arr;
    static int[] sum = new int[3];
    static int max = 0;
    static int M;
    public int sum() {
        int total = 0;
        for(int s : sum) {
            total += s;
        }
        if(total <= M)
            return max = Math.max(max, total);
        return max;
    }
    public void combination(int idx, int s_idx) {
        if(s_idx == 3) {
            sum();
            return;
        }
        if(idx == arr.length) {
            return;
        }
        sum[s_idx] = arr[idx];
        combination(idx+1, s_idx+1);
        combination(idx+1, s_idx);
    }
}
