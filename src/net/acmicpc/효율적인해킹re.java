package net.acmicpc;

import java.util.*;

//인접행렬로 풀 수 없음. dfs도 남에서 나를 찾아야지 시간을 초과하지않음.
public class 효율적인해킹re {
    static int N;
    static int M;
    static List<Integer>[] list;
    static int[] count;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();
        list = new ArrayList[10001];
        count = new int[10001];
        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList();
        }
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
        }
        int max = 0;
        for(int i = 1; i <= N; i++) {
            visited = new boolean[10001];
            dfs(i);
        }
        for(int i = 1; i <= N; i++) {
            if(max < count[i]) {
                max = count[i];
            }
        }
//        for(int i = 0; i < M; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            list[b].add(a);
//        }
//        int max = 0;
//        for(int i = 1; i <= W; i++) {
//            //방문하는정점, 시작정점
//            visited1 = new boolean[10001];
////            dfs(i, i);
//            bfs(i);
//            if(max < count[i]) {
//                max = count[i];
//            }
//        }
        for(int i = 1; i <= N; i++) {
            if(count[i] == max) {
                sb.append(i+" ");
            }
        }
        System.out.println(sb.toString());
    }
    public static void dfs(int start) {
        visited[start] = true;
        for(int l : list[start]) {
            if(!visited[l]) {
                count[l]++;
                dfs(l);
            }
        }
    }
    public static void dfs(int v, int start) {
        //방문체크
        //v랑 연결된 노드들 중에서 방문안한곳 방문하기
        visited[v] = true;
//        System.out.print(v+" ");
        for(int l : list[v]) {
            if(!visited[l]) {
                dfs(l, start);
            }
        }
    }
    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList();
        que.add(start);
        visited[start] = true;
        count[start]++;
        while(!que.isEmpty()) {
            int num = que.poll();
            count[start]++;
            for(int l : list[num]) {
                if(!visited[l]) {
                    visited[l] = true;
                    que.add(l);
                }
            }
        }
    }
}
