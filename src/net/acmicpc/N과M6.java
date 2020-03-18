package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M6 {
    static int N;
    static int M;
    static int[] arr;
    static int[] sub;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N];
        sub = new int[M];
        sb = new StringBuilder();
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        combination(0, 0);
        System.out.println(sb);
    }
    static void combination(int idx, int s_idx) {
        if(s_idx == M) {
            for(int s : sub) {
                sb.append(s+" ");
            }
            sb.append("\n");
            return;
        }
        if(idx == N) {
            return;
        }
        sub[s_idx] = arr[idx];
        combination(idx+1, s_idx+1);
        combination(idx+1, s_idx);
    }
}
