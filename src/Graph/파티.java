package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1238
public class 파티 {
    static final int INF = 1234567;
    static class Node implements Comparable<Node> {
        int idx;
        int weight;
        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }
    }
    static List<List<Node>> list;
    static List<List<Node>> reverseList;
    static int[][] arr;
    static int[] dist;
    static int[] reverseDist;
    static int N;
    static int M;
    static int X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        X = Integer.parseInt(token.nextToken());
        arr = new int[N+1][N+1];
        list = new ArrayList<>();
        reverseList = new ArrayList<>();
        dist = new int[N+1];
        reverseDist = new int[N+1];
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());;
            reverseList.add(new ArrayList<>());
        }
        Arrays.fill(dist, INF);
        Arrays.fill(reverseDist, INF);
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            int value = Integer.parseInt(token.nextToken());
            list.get(n1).add(new Node(n2, value));
            reverseList.get(n2).add(new Node(n1, value));
        }
        dijkstra(list, dist, X);
        dijkstra(reverseList, reverseDist, X);
        int answer = 0;
        for(int i = 1; i <= N; i++)
            answer = Math.max(answer, dist[i]+reverseDist[i]);
        System.out.println(answer);
    }
    static void dijkstra(List<List<Node>> list, int[] dist, int start) {
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Node> que = new PriorityQueue<Node>();
        que.add(new Node(start, 0));
        dist[start] = 0;
        while(!que.isEmpty()) {
            int idx = que.poll().idx;
            if(visited[idx])
                continue;
            visited[idx] = true;
            for(Node node : list.get(idx)) {
                if(dist[node.idx] > dist[idx] + node.weight) {
                    dist[node.idx] = dist[idx]+node.weight;
                    que.add(new Node(node.idx, dist[node.idx]));
                }
            }
        }
    }
}
