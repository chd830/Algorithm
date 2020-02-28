package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 로또 {
    static int N;
    static int[] arr;
    static int[] sub;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            if (N == 0) {
                System.exit(0);
            }
            arr = new int[N];
            sub = new int[6];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }
            permute(0, 0);
            System.out.println();
        }
    }
    static void permute(int idx, int s_idx) {
        if(s_idx == sub.length) {
            for(int i : sub) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        if(idx == arr.length) {
            return;
        }
        sub[s_idx] = arr[idx];
        permute(idx+1, s_idx+1);
        permute(idx+1, s_idx);
    }
}
