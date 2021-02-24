package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS1260 {
    static List<Integer>[] list;
    static boolean[] visit;
    static StringBuilder sb;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int V  = Integer.parseInt(token.nextToken());
        int[][] arr = new int[N+1][M+1];

        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            arr[n1][n2] = 1;
            arr[n2][n1] = 1;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(V);
        //dfs
        boolean[] visited = new boolean[N+1];
        visited[0] = true;
        visited[V] = true;
        while(!stack.isEmpty()) {
            int start = stack.pop();
            System.out.print(start+" ");
            for(int i = 1; i <= M; i++) {
                if(arr[start][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
        //bfs
        visited = new boolean[N+1];
        visited[0] = true;
    }
    public static void main(String[] args) throws IOException {
        solution();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer token = new StringTokenizer(br.readLine());
//        sb = new StringBuilder();
//        int N = Integer.parseInt(token.nextToken());
//        int M = Integer.parseInt(token.nextToken());
//        int V = Integer.parseInt(token.nextToken());
//        list = new ArrayList[N + 1];
//        visit = new boolean[N + 1];
//        for (int i = 0; i <= N; i++) {
//            list[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < M; i++) {
//            token = new StringTokenizer(br.readLine());
//            int n1 = Integer.parseInt(token.nextToken());
//            int n2 = Integer.parseInt(token.nextToken());
//            list[n1].add(n2);
//            list[n2].add(n1);
//        }
//        for(int i = 0; i <= N; i++) {
//            Collections.sort(list[i]);
//        }
//        dfs(V);
//        sb.append("\cur");
//        visit = new boolean[N + 1];
//        bfs(V);
//        System.out.println(sb);
    }

    static void dfs(int start) {
        visit[start] = true;
        sb.append(start).append(" ");
        for (int i : list[start]) {
            if (!visit[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        sb.append(start).append(" ");
        visit[start] = true;
        while (!que.isEmpty()) {
            int n = que.poll();
            for (int i : list[n]) {
                if (!visit[i]) {
                    visit[i] = true;
                    que.add(i);
                    sb.append(i).append(" ");
                }
            }
        }
    }

}
