package net.acmicpc.re;

import java.util.*;
import java.io.*;

//순열
public class N과M {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        visited = new boolean[N];
        arr = new int[M];
        perm(0);
    }

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;

    public static void perm(int idx) {
        if(idx == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[idx] = i+1;
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
}
