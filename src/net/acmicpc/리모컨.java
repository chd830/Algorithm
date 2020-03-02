package net.acmicpc;

import java.util.Scanner;

public class 리모컨 {
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            broken[sc.nextInt()] = true;
        }
        if (N == 100) {
            System.out.println(0);
            System.exit(0);
        }
        for(int i = 0; i <= 500000; i++) {
            if(possible(i)) {
                result = Math.min(Math.abs(i - N), result);
            }
        }
    }
    public static boolean possible(int n) {
        while(n > 0) {
            if(broken[n%10]) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}