package net.acmicpc;

import java.io.*;
import java.util.*;

public class 최단경로 {
    static class Edge implements Comparable<Edge> {
        int target;
        int weight;
        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int V = Integer.parseInt(token.nextToken());
        int E = Integer.parseInt(token.nextToken());
        List<Edge>[] list = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            list[i] = new ArrayList<>();
        }
        int start = Integer.parseInt(br.readLine())-1;
        for(int i = 0; i < E; i++) {
            token = new StringTokenizer(br.readLine());
            list[Integer.parseInt(token.nextToken())-1].add(new Edge(Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())));
        }
        PriorityQueue<Edge> que = new PriorityQueue<>();
        boolean[] visited = new boolean[V];
        Edge[] D = new Edge[V];
        for(int i = 0; i < V; i++) {
            if(i == start) {
                D[i] = new Edge(i, 0);
            }
            else {
                D[i] = new Edge(i, Integer.MAX_VALUE);
            }
            que.add(D[i]);
        }
        while(!que.isEmpty()) {
            Edge edge = que.poll();
            for(Edge next : list[edge.target]) {
                if(!visited[next.target] && D[next.target].weight > D[edge.target].weight+next.weight) {
                    D[next.target].weight = D[edge.target].weight + next.weight;
                    que.remove(D[next.target]);
                    que.add(D[next.target]);
                }
            }
            visited[edge.target] = true;
        }
        for(Edge e : D) {
            if(e.weight == Integer.MAX_VALUE || e.weight < 0) {
                sb.append("INF").append("\n");
            }
            else {
                sb.append(e.weight).append("\n");
            }
        }
        System.out.println(sb);
    }
}