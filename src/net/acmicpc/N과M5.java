package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M5 {
    static int N;
    static int M;
    static int[] arr;
    static int[] sub;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N];
        sub = new int[M];
        visited = new boolean[N];
        sb = new StringBuilder();
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        permute(0);
        System.out.println(sb);
    }
    static void permute(int idx) {
        if(idx == M) {
            for(int s : sub) {
                sb.append(s+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[idx] = arr[i];
                permute(idx+1);
                visited[i] = false;
            }
        }
    }
}
