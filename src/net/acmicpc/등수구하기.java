package net.acmicpc;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1205
public class 등수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int grade = Integer.parseInt(token.nextToken());
        int P = Integer.parseInt(token.nextToken());
        int[] arr = null;
        if(N != 0) {
            token = new StringTokenizer(br.readLine());
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }
        }
        int idx = 1;
        for(int i = 0; i < N; i++) {
            if(arr[i] > grade)
                idx++;
            else
                break;
        }
        if(N == P && arr[N-1] < grade)
            System.out.println(idx);
        else if(N == P)
            System.out.println(-1);
        else
            System.out.println(idx);
    }
}
