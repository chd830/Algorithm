package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1197
public class 최소스패닝트리 {
    static class Node implements Comparable<Node> {
        int from;
        int to;
        int val;
        Node(int from, int to, int val) {
            this.from = from;
            this.to = to;
            this.val = val;
        }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.val, o.val);
    }
}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(token.nextToken());
        int E = Integer.parseInt(token.nextToken());
        parents = new int[V+1];
        for(int i = 0; i <= V; i++)
            parents[i] = i;
        PriorityQueue<Node> que = new PriorityQueue<>();
        for(int i = 0; i < E; i++) {
            token = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(token.nextToken());
            int v2 = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());
            que.add(new Node(v1, v2, cost));
        }
        long sum = 0;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(find(n.from) != find(n.to)) {
                union(n.from, n.to);
                sum += n.val;
            }
        }
        System.out.println(sum);
    }
    static int[] parents;
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parents[b] = a;
    }
    static int find(int a) {
        if(a == parents[a])
            return a;
        return parents[a] = find(parents[a]);
    }
}
