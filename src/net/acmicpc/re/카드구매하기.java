package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 11052
public class 카드구매하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] d = new int[N+1];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                d[i] = Math.max(d[i], d[i-j]+arr[j]);
            }
        }
        System.out.println(d[N]);
    }
}
