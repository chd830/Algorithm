package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 9466
// dfs로 접근하면 시간초과 O(n)으로 처리되도록 해야함
public class 텀프로젝트 {
    static int N;
    static int cnt;
    static int[] arr;
    static boolean[] check;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            cnt = 0;
            arr = new int[N+1];
            visited = new boolean[N+1];
            check = new boolean[N+1];
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++)
                arr[i] = Integer.parseInt(token.nextToken());
            for(int i = 1; i <= N; i++)
                    check(i);
            System.out.println(N-cnt);
        }
    }
    static void check(int cur) {
        if(visited[cur])
            return;
        visited[cur] = true;
        int next = arr[cur];
        if(!visited[next])
            check(next);
        if(!check[next]) {
            cnt++;
            for(int i = next; i != cur; i = arr[i])
                cnt++;
        }
        check[cur] = true;
    }
}
