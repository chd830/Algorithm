package net.acmicpc;

import java.util.*;

public class 피보나치수5 {
    static int result;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        result = 0;
        N  = sc.nextInt();
        if(N == 0) {
            System.out.println(0);
            System.exit(0);
        }
        else if(N == 1) {
            System.out.println(1);
            System.exit(0);
        }
        fibo(result, result+1, 1);
        System.out.println(result);
    }
    public static void fibo(int p, int prev, int count) {
        if(count == N) {
            return;
        }
        result = p + prev;
        fibo(prev, result, count+1);
    }
}
