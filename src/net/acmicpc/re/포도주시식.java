package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 2156
public class 포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] d = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if(N <= 2) {
            System.out.println(N == 1 ? arr[1] : arr[1]+arr[2]);
            System.exit(0);
        }

        d[1] = arr[1];
        d[2] = arr[1]+arr[2];
        for(int i = 3; i <= N; i++)
            d[i] = Math.max(d[i-2]+arr[i], Math.max(d[i-3]+arr[i-1]+arr[i], d[i-1]));
        System.out.println(d[N]);
    }
}