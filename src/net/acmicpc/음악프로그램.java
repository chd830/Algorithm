package net.acmicpc;

import java.util.*;

public class 음악프로그램 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] pre = new int[N+1];
        List<Integer>[] adj = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            adj[i] = new ArrayList();
        }
        for(int i = 0; i < M; i++) {
            int m = sc.nextInt();
            int start = sc.nextInt();
            int end = 0;
            for(int j = 0; j < m-1; j++) {
                end = sc.nextInt();
                adj[start].add(end);
                pre[end]++;
                start = end;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(pre[i] == 0) {
                que.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(!que.isEmpty()) {
            count++;
            int n = que.poll();
            sb.append(n).append("\n");
            for(int i = 0; i < adj[n].size(); i++) {
                if(--pre[adj[n].get(i)] == 0) {
                    que.add(adj[n].get(i));
                }
            }
        }
        if(count != N) {
            System.out.println(0);
        }
        else {
            System.out.println(sb);
        }
    }
}
