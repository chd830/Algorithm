package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 효율적인해킹 {
    static int N;
    static int M;
    static int cnt;
    static int[] count;
    static List<Integer>[] list;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        int[] arr = new int[N+1];
        M = Integer.parseInt(token.nextToken());
        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList();
        }
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            list[a].add(b);
            list[b].add(a);

        }
    }
}
