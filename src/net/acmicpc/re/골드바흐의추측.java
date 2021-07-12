package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 6588
public class 골드바흐의추측 {
    static boolean[] prime = new boolean[1000001];
    static void check() {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int i = 2; i < prime.length; i++) {
            for(int j = i+i; j < prime.length; j += i) {
                prime[j] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        check();
        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            int n1 = 0;
            int n2 = n;

            for(int i = 0; i <= n/2; i++) {
                if(prime[n1] && prime[n2]) {
                    break;
                }
                n1++;
                n2--;
            }

            if (n1 == 0 && n2 == n)
                sb.append("GoldBach's conjecture is wrong.").append("\n");
            else
                sb.append(n).append(" = ").append(n1).append(" + ").append(n2).append("\n");
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb.toString());
    }
}
