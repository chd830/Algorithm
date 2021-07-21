package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 11047
public class 동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        while(M > 0) {
            if(M/arr[--N] > 0) {
                cnt += M/arr[N];
                M %= arr[N];
            }
        }
        System.out.println(cnt);
    }
}
