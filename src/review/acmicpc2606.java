package review;

import java.util.*;
import java.io.*;

// 바이러스
public class acmicpc2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        StringTokenizer token = null;
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        visited[1] = true;
        dfs(1);
        int cnt = 0;
        for(boolean visit : visited) {
            if(visit)
                cnt++;
        }
        System.out.println(cnt-1);
    }
    static boolean[] visited;
    static List<Integer>[] list;
    static void dfs(int num) {
        for(int i : list[num]) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}