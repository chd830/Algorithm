package Study;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1260
public class DFS와BFS {

    // GRAPH
    // 1 - 2
    // 1 - 3
    // 1 - 4
    // 인접리스트
    // List<List<Integer>>[] list = new ArrayList[5];
    // List<Integer> l1;
    // List<Integer> l2;
    // List<Integer> l3;
    // 1하고 누가 연결되어있나요? 2, 3, 4요!
    // 인접배열
    // int[][] arrs = new int[5][5];
    // int[] a1;
    // int[] a2;
    // int[] a3;
    // 1하고 1이 연결되어있나요? 아니용
    // 1하고 2가 연결되어있나요? 넹
    static List<Integer>[] list;
    static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int V = Integer.parseInt(token.nextToken());
        list = new ArrayList[N+1];
        arr = new boolean[N+1][N+1];
        for(int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
            arr[n1][n2] = true;
            arr[n2][n1] = true;
        }
        System.out.println("인접 리스트");
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j < list[i].size(); j++)
                System.out.print(list[i].get(j)+" ");
            System.out.println();
        }
        System.out.println();
        System.out.println("인접 배열");
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= N; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
        System.out.println();
        // DFS(Depth)
        // 방문한 점과 방문하지 않은점을 나눠서
        // 방문하지 않은 지점을 방문
        visited = new boolean[N+1];
        visited[V] = true;
        dfs(V);
        System.out.println();
        // BFS(Breadth)
        // 우선 다 방문해
        visited = new boolean[N+1];
        visited[V] = true;
        bfs(V);
    }
    static boolean[] visited;
    static void dfs(int idx) {
        System.out.print(idx+" ");
        for(int i : list[idx]) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i);
//                visited[i] = false;
            }
        }
    }
    static void bfs(int idx) {
        Queue<Integer> que = new LinkedList<>();
        que.add(idx);
        while(!que.isEmpty()) {
            int num = que.poll();
            System.out.print(num+" ");
            for(int i : list[num]) {
                if(!visited[i]) {
                    visited[i] = true;
                    que.add(i);
                }
            }
        }
    }
}
