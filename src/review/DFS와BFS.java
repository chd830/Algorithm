package review;

import java.io.*;
import java.util.*;

public class DFS와BFS {
    static int N;
    static int M;
    static int V;
    static boolean[] visited;
    static List<Integer>[] list;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        V = Integer.parseInt(token.nextToken())-1;
        list = new List[N];
        sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(token.nextToken()) - 1;
            int num2 = Integer.parseInt(token.nextToken()) - 1;
            list[num1].add(num2);
            list[num2].add(num1);
        }
        for(int i = 0; i < N; i++) {
            Collections.sort(list[i]);
        }
        visited = new boolean[N];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N];
        bfs();
        sb.append("\n");
        System.out.println(sb);
    }
    static void dfs(int V) {
        visited[V] = true;
        sb.append(V+1).append(" ");
        for(int nums : list[V]) {
            if(!visited[nums]) {
                dfs(nums);
            }
        }
    }
    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(V);
        visited[V] = true;
        while(!que.isEmpty()) {
            int n = que.poll();
            sb.append(n+1).append(" ");
            for(int nums : list[n]) {
                if(!visited[nums]) {
                    visited[nums] = true;
                    que.add(nums);
                }
            }
        }
    }

}
