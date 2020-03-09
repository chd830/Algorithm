package Concept;

import java.util.Scanner;

public class 피보나치 {
    static long totalCnt1 = 0;
    static long totalCnt2 = 0;
    static long[] call1;
    static long[] call2;
    static long[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        call1 = new long[N+1];
        call2 = new long[N+1];
        memo = new long[N+1];
        System.out.println(fiboMemo(N));
        for(int i = 1; i <= N; i++) {
            System.out.println("fiboMemo("+i+"): "+call2[i]);
        }
        System.out.println(totalCnt2);
        System.out.println(fibo(N));
        for(int i = 1; i <= N; i++) {
            System.out.println("fibo("+i+"): "+call1[i]);
        }
        System.out.println(totalCnt1);
    }

    public static long fibo(int n) {
        ++call1[n];
        ++totalCnt1;
        if(n <= 1) return n;
        return fibo(n-1) + fibo(n-2);
    }


    public static long fiboMemo(int n) {
        ++call2[n];
        ++totalCnt2;
        if(n <= 1) return n;
        if(memo[n] != 0) return memo[n];
        return memo[n] = fibo(n-1) + fibo(n-2);
    }
    //1, 1, 2, 3, 5, 8, 13, 21, 34, 55
}
