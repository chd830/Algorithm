package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 1149
public class RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][3];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(token.nextToken());
            arr[i][1] = Long.parseLong(token.nextToken());
            arr[i][2] = Long.parseLong(token.nextToken());
        }

        for(int i = 1; i < N; i++) {
            arr[i][0] += min(arr[i-1][1], arr[i-1][2]);
            arr[i][1] += min(arr[i-1][0], arr[i-1][2]);
            arr[i][2] += min(arr[i-1][0], arr[i-1][1]);
        }
        System.out.println(min(min(arr[N-1][0], arr[N-1][1]), arr[N-1][2]));
    }

    static long min(long a, long b) {
        if(a < b)
            return a;
        return b;
    }
}