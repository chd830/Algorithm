package com.swexpertacademy;

import java.util.Scanner;

//퀴즈
public class d4_7965 {
    final static long SIZE = 1_000_000_007;
    public static void main(String[] args) {
        long[] nums = new long[1000001];
        for(int i = 1; i <= 1000000; i++) {
            nums[i] = (nums[i-1] + pow(i, i)) % SIZE;
        }
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            System.out.println("#"+t+" "+nums[N]);
        }
    }
    public static long pow(int a, int b) {
        if(b == 1)
            return a;
        long tmp = pow(a, b/2);
        if(b%2 == 0)
            return tmp * tmp % SIZE;
        else
            return tmp * tmp % SIZE * a % SIZE;
    }
}
