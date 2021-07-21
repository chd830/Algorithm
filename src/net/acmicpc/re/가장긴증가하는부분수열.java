package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 11053
public class 가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] d = new int[N+1];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int max = 0;
//        Arrays.fill(d, 1);
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j])
                    d[i] = Math.max(d[i], d[j]+1);
            }
            max = Math.max(max, d[i]);
        }
        System.out.println(max);
    }
}
