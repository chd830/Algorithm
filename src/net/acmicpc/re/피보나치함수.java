package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 1003
public class 피보나치함수 {
    static int[] zero = new int[41];
    static int[] one = new int[41];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        zero[0] = 1;
        one[0] = 0;

        zero[1] = 0;
        one[1] = 1;

        for(int i = 2; i <= 40; i++) {
            zero[i] = zero[i-1] + zero[i-2];
            one[i] = one[i-1] + one[i-2];
        }
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            System.out.println(zero[N]+" "+one[N]);
        }
    }
    static int fibonacci(int n) {
        if(n == 0) {
            System.out.print(0+" ");
            return n;
        }
        else if(n == 1) {
            System.out.print(1+" ");
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
