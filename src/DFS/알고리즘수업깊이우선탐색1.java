package DFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/24479
public class 알고리즘수업깊이우선탐색1 {
    static int N;
    static List<Integer>[] list;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int start = Integer.parseInt(token.nextToken());
        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }
        for(int i = 1; i <= N; i++)
            Collections.sort(list[i]);
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        cnt = 1;
        distance[start] = cnt++;
        dfs(start);
        for(int i = 1; i <= N; i++) {
            System.out.println(distance[i] == Integer.MAX_VALUE ? 0 : distance[i]);
        }
    }
    static int cnt;
    static void dfs(int cur) {
        for(int i : list[cur]) {
            if(distance[i] == Integer.MAX_VALUE) {
                distance[i] = cnt++;
                dfs(i);
            }
        }
    }
}
