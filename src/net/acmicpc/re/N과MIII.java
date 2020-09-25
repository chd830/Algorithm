package net.acmicpc.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과MIII {
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[M];
        perm(0);
    }

    static void perm(int idx) {
        if (idx == M) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[idx] = i + 1;
            perm(idx + 1);
        }
    }
}
