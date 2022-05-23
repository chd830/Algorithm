package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1647
public class 도시분할 {
    static class Node implements Comparable<Node> {
        int from;
        int to;
        int val;
        Node(int to, int val) {
            this.to = to;
            this.val = val;
        }
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
    static int[] parents;
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        list = new ArrayList[N+1];
        parents = new int[N+1];
        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
            parents[i] = i;
        }
        PriorityQueue<Node> que = new PriorityQueue<>();
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            int val = Integer.parseInt(token.nextToken());
            list[n1].add(new Node(n2, val));
            list[n2].add(new Node(n1, val));
            que.add(new Node(n1, n2, val));
        }
        int cnt = 0;
        int prev = 0;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(find(n.from) != find(n.to)) {
                union(n.from, n.to);
                cnt += n.val;
                prev = n.val;
            }
        }
        System.out.println(cnt-prev);
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b)
            parents[b] = a;
    }
    static int find(int a) {
        if(a == parents[a])
            return a;
        return parents[a] = find(parents[a]);
    }
}