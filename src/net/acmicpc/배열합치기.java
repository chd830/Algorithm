package net.acmicpc;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11728
public class 배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        long[] arr1 = new long[N];
        long[] arr2 = new long[M];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr1[i] = Long.parseLong(token.nextToken());
        }
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            arr2[i] = Long.parseLong(token.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int count = 0, i = 0, j = 0; count < N+M; count++) {
            if(i >= N) {
                sb.append(arr2[j]).append(" ");
                j++;
            }
            else if(j >= M) {
                sb.append(arr1[i]).append(" ");
                i++;
            }
            else if(arr1[i] < arr2[j]) {
                sb.append(arr1[i]).append(" ");
                i++;
            }
            else {
                sb.append(arr2[j]).append(" ");
                j++;
            }
        }
        System.out.println(sb.toString());
    }
}