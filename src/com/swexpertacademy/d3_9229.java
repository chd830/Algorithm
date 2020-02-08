package com.swexpertacademy;

import java.util.Scanner;

//한빈이와 Spot
public class d3_9229 {
    static int[] arr;
    static int[] sub = new int[2];
    static int N;
    static int M;
    static int max;
    //    public static void main(String[] args) {
    public d3_9229() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            max = 0;
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            combination(0, 0);
            if(max != 0) {
                System.out.println("#" + t + " " + max);
            }
            else {
                System.out.println("#"+t+" -1");
            }
        }
    }

    public static void combination(int idx, int a_idx) {
        if (a_idx == sub.length) {
            int sum = 0;
            for(int s : sub) {
                sum += s;
            }
            if(sum <= M) {
                max = Math.max(sum, max);
            }
            return;
        }
        if (idx == arr.length) {
            return;
        }
        sub[a_idx] = arr[idx];
        combination(idx + 1, a_idx + 1);
        combination(idx + 1, a_idx);
    }
}
