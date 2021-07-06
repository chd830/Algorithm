package net.acmicpc.re;

import java.util.*;
import java.io.*;

public class 소수찾기 {
    static boolean[] prime = new boolean[1001];
    static void check() {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int i = 2; i < prime.length; i++) {
            for(int j = i+i; j < prime.length; j += i)
                prime[j] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        check();
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            if(prime[Integer.parseInt(token.nextToken())])
                cnt++;
        }
        System.out.println(cnt);
    }
}
