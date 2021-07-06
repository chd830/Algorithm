package net.acmicpc.re;

import java.util.*;
import java.io.*;

public class 최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int gcd = max(N, M);
        System.out.println(gcd);
        System.out.println(N/gcd*M/gcd*gcd);
    }
    static int max(int n, int m) {
        if(m == 0)
            return n;
        return max(m, n%m);
    }
}
