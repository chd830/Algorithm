package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2749
public class 피보나치수 {
    // 피사노주기를 이용하여 접근 필요.
    static long[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        N %= 1500000;
        int num = (int)N;
        d = new long[1500001];
        d[1] = 1;
        for(int i = 2; i <= 1500000; i++) {
            d[i] = (d[i-1]+d[i-2])%1000000;
        }
//        fibo(num);
        System.out.println(d[num]);
    }
//    static long fibo(int N) {
//        if(N < 2)
//            return N;
//        if(d[N] != 0)
//            return d[N];
//        return d[N] = (fibo(N-1)+fibo(N-2))%1000000;
//    }
}