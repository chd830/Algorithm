package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 2529
public class 부등호 {
    static int N;
    static long min = Long.MAX_VALUE;
    static long max = 0;
    static int[] sub;
    static boolean[] sign;
    static boolean[] visited = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sub = new int[N+1];
        sign = new boolean[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            switch (token.nextToken()) {
                case "<":
                    sign[i] = true;
                    break;
                case ">":
                    sign[i] = false;
                    break;
            }
        }
        perm(0);
        System.out.println(String.valueOf(max).length() == N ? "0"+max : max);
        System.out.println(String.valueOf(min).length() == N ? "0"+min : min);
    }
    static boolean check() {
        for(int i = 0; i < N; i++) {
            if(sign[i]) {
                if(sub[i] < sub[i+1])
                    continue;
                return false;
            }
            else {
                if(sub[i] > sub[i+1])
                    continue;
                return false;
            }
        }
        return true;
    }
    static long arrToLong() {
        String num = "";
        for(int i : sub)
            num += i;
        return Long.parseLong(num);
    }
    static void perm(int idx) {
        if(idx == N+1) {
            if(check()) {
                Long num = arrToLong();
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            return;
        }
        for(int i = 0; i < 10; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[idx] = i;
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
}
