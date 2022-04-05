package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1504
public class 특정한최단경로 {
    static List<Node>[] list;
    static class Node implements Comparable<Node> {
        int x;
        int val;
        Node(int x, int val) {
            this.x = x;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.val, o.val);
        }
    }
    static final int INF = 12345678;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        V = Integer.parseInt(token.nextToken());
        int E = Integer.parseInt(token.nextToken());
        visited = new boolean[V+1];
        list = new ArrayList[V+1];
        for(int i = 0; i <= V; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < E; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            int val = Integer.parseInt(token.nextToken());
            list[n1].add(new Node(n2, val));
            list[n2].add(new Node(n1, val));
        }
        token = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(token.nextToken());
        v2 = Integer.parseInt(token.nextToken());
        d = new int[V+1];
        d[1] = 0;
        dirkstra(1);
        int startToV1 = d[v1];
        int startToV2 = d[v2];
        dirkstra(v1);
        int dist = d[v2];
        int v1ToV = d[V];
        dirkstra(v2);
        int v2ToV = d[V];
        int res = Math.min(startToV1+dist+v2ToV, startToV2+dist+v1ToV);
        if(dist == INF || res >= INF)
            System.out.println(-1);
        else
            System.out.println(res);
    }
    static boolean[] visited;
    static int[] d;
    static int V;
    static int v1;
    static int v2;
    static void dirkstra(int cur) {
        Arrays.fill(d, INF);
        d[cur] = 0;
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(cur, 0));
        while(!que.isEmpty()) {
            Node node = que.poll();
            for (Node n : list[node.x]) {
                if (d[n.x] > d[node.x] + n.val) {
                    d[n.x] = d[node.x] + n.val;
                    que.add(n);
                }
            }
        }
    }
}
