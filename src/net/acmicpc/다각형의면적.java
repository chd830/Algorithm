package net.acmicpc;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2166
public class 다각형의면적 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N+1][2];
        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(token.nextToken());
            arr[i][1] = Integer.parseInt(token.nextToken());
        }
        arr[N][0] = arr[0][0];
        arr[N][1] = arr[0][1];
        double sumA = 0;
        double sumB = 0;
        for(int i = 0; i < N; i++) {
            sumA += arr[i][0] * arr[i+1][1];
            sumB += arr[i+1][0] * arr[i][1];
        }
        String answer = String.format("%.1f", (Math.abs(sumA-sumB)/2.0));
        System.out.println(answer);
    }
}
