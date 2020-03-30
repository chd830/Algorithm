package net.acmicpc;

import java.io.*;
import java.util.*;

public class 효율적인해킹 {
    static int N;
    static int M;
    static int cnt;
    static boolean[] visited;
    static List<Integer>[] list;
    static int[] check;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();
        list = new ArrayList[100001];
        check = new int[100001];
        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList();
        }
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
        }
        for(int i = 1; i <= N; i++) {
            if(list[i].size() != 0) {
                visited = new boolean[100001];
                dfs(i);
//                bfs(i);
//                Arrays.fill(visited1, false);
            }
        }
        int max = 0;
        for(int i = 1; i <= N; i++) {
            if(max < check[i]) {
                max = check[i];
            }
        }
        for(int i = 1; i <= N; i++) {
            if(check[i] == max) {
                sb.append(i+" ");
            }
        }
        System.out.println(sb.toString());
    }
    public static void dfs(int start) {
        visited[start] = true;
        for(int l : list[start]) {
            if(!visited[l]) {
                check[l]++;
                dfs(l);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        while(!que.isEmpty()) {
            int num = que.poll();
            for(int n : list[num]) {
                if(!visited[n]) {
                    que.add(n);
                    visited[n] = true;
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            if(visited[i] == true) {
                cnt++;
            }
        }
        check[start] = cnt;
        cnt = 0;
    }
}
