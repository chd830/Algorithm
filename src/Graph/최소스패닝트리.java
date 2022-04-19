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
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(token.nextToken());
        int E = Integer.parseInt(token.nextToken());
        long sum = 0;
        parent = new int[V+1];
        for(int i = 1; i <= V; i++)
            parent[i] = i;
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < E; i++) {
            token = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            Node n = list.get(i);
            if(find(n.from) != find(n.to)) {
                sum += n.val;
                union(n.from, n.to);
            }
        }
        System.out.println(sum);
    }
    static int find(int x) {
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y)
            parent[y] = x;
    }
}
