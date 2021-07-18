package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 1912
public class 연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] d = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        d[0] = arr[0];
        int max = d[0];
        for(int i = 1; i < N; i++) {
            d[i] = Math.max(d[i-1]+arr[i], arr[i]);
            max = Math.max(max, d[i]);
        }
        System.out.println(max);
    }
}
