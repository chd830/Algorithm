package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 2606
public class 바이러스 {
    static int N;
    static int M;
    static int cnt;
    static boolean[] visited;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 0; i < N+1; i++)
            list[i] = new ArrayList<>();
        StringTokenizer token = null;
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }
        cnt = -1;
        dfs(1);
        System.out.println(cnt);
    }
    static void dfs(int cur) {
        for(int i : list[cur]) {
            if(!visited[i]) {
                cnt++;
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
