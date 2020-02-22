package net.acmicpc;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M4 {
    static int[] arr;
    static int[] sub;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = (i+1);
        }
        sub = new int[M];
        perm(0, 0);
        bw.flush();
    }
    public static void perm(int idx, int s_idx) throws IOException {
        if(s_idx == sub.length) {
            for(int i = 0; i < s_idx; i++) {
                bw.write(sub[i]+" ");
            }
            bw.write("\n");
            return;
        }
        if(idx == arr.length) {
            return;
        }
        sub[s_idx] = arr[idx];
        perm(idx, s_idx+1);
        perm(idx+1, s_idx);
    }
}
