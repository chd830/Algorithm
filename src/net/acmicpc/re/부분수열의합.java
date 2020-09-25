package net.acmicpc.re;

import java.util.*;
import java.io.*;

public class 부분수열의합 {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        visited = new boolean[N];
        arr = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        //부분집합을 구하고 각각의 부분집합의 합을 구해서 M일 때 카운팅한다.
        sub(0);
        System.out.println(result-1);
    }
    static int cnt = 0;
    static int result = 0;
    public static void sub(int idx) {
        if(idx == N) {
            int sum = 0;
            for(int i = 0; i < N; i++) {
                if(visited[i]) {
                    System.out.print(arr[i]+"\t");
                    sum += arr[i];
                }
            }
            System.out.println("\t"+sum);
            if(sum == M) {
                result++;
            }
            return;
        }
        visited[idx] = true;
        sub(idx+1);
        visited[idx] = false;
        sub(idx+1);
    }
}
