package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1068
public class 트리 {
    static int cnt;
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        for(int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();
        visited = new boolean[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        int parent = 0;
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(token.nextToken());
            if(n == -1)
                parent = i;
            else
                graph[n].add(i);
        }
        int remove = Integer.parseInt(br.readLine());
        visited[remove] = true;
        if(remove == parent)
            System.out.println(0);
        else {
            cycle(parent);
            System.out.println(cnt);
        }
    }
    static void cycle(int idx) {
        boolean flag = true;
        for(int i : graph[idx]) {
            if(!visited[i]) {
                flag = false;
                visited[i] = true;
                cycle(i);
            }
        }
        if(flag)
            cnt++;
    }
}