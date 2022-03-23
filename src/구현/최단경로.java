package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1753
public class 최단경로 {
    static int V;
    static int E;
    static List<Node>[] list;
    static class Node implements Comparable<Node> {
        int idx;
        int weight;
        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static final int INF = 1234567;
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(token.nextToken());
        int E = Integer.parseInt(token.nextToken());
        list = new ArrayList[V+1];
        for(int i = 0; i <= V; i++)
            list[i] = new ArrayList<>();
        int start = Integer.parseInt(br.readLine());
        for(int i = 0; i < E; i++) {
            token = new StringTokenizer(br.readLine());
            list[Integer.parseInt(token.nextToken())].add(new Node(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }

        distance = new int[V+1];
        visited = new boolean[V+1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0));
        while(!que.isEmpty()) {
            int idx = que.poll().idx;
            if(visited[idx]) continue;
            visited[idx] = true;
            for(Node next : list[idx]) {
                if(!visited[next.idx] && distance[next.idx] > distance[idx]+next.weight) {
                    distance[next.idx] = distance[idx]+next.weight;
                    que.add(new Node(next.idx, distance[next.idx]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++) {
            if(distance[i] == INF)
                sb.append("INF").append("\n");
            else
                sb.append(distance[i]).append("\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}