package net.acmicpc;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2661
public class 좋은수열 {
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        dfs("1", N);
    }
    static void dfs(String str, int N) {
        if(str.length() == N) {
            System.out.println(str);
            System.exit(0);
        }
        for(int i = 1; i <= 3; i++) {
            if(check(str+i))
                dfs(str+i, N);
        }
    }
    // 마지막에 추가된 값때문에 중복이 생기는지를 판별한다.
    static boolean check(String str) {
        int len = str.length();
        int start = len-1;
        int end = len;
        int idx = 1;
        while(start >= idx) {
            if(str.substring(start-idx, end-idx).equals(str.substring(start, end)))
                return false;
            start--;
            idx++;
        }
        return true;
    }
}
