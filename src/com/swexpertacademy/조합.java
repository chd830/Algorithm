package com.swexpertacademy;

import java.util.Scanner;

public class 조합 {
    static final int MOD = 1234567891;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            long N = sc.nextInt();
            long K = sc.nextInt();
            long result = (fac(N) * pow(fac(N-K)*fac(K)%MOD, MOD-2))%MOD;
            System.out.println("#" + t + " " + result);
        }
    }

    static long fac(long n) {
        long result = 1;
        while (n > 1) {
            result = (result * n) % MOD;
            n--;
        }
        return result;
    }
    static long pow(long a, long b) {
        long result = 1;
        long num = a%MOD;
        while(b > 0) {
            result *= num;
            result %= MOD;
            b--;
        }
        return result;
    }
    public static long power(long base, long ex) {
        if(ex == 0)
            return 1;
        else if(ex == 1)
            return base;
        else if(ex%2 == 0) {
            long result= power(base, ex/2)%MOD;
            return result*result%MOD;
        }
        else {
            long result = power(base, ex/2)%MOD;
            return result * result%MOD * base%MOD;
        }
    }
    //2^4 = 2^2 * 2*2 이용
    static long pow(long a, int b) {
        long result= 1;
        long num = a;
        while (b > 0) {
            if (b%2 == 1) {
                result = result * num  % MOD;
            }
            b = b/2;
            num = (num * num) % MOD;
        }
        return result;
    }
}