package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/4386
public class 별자리만들기 {
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
    static class Node implements Comparable<Node> {
        double cost;
        int from;
        int to;
        Node(double cost, int from, int to) {
            this.cost = cost;
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.cost, o.cost);
        }
    }
    static class Star {
        double x;
        double y;
        Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = null;
        parents = new int[N+1];
        for(int i = 1; i <= N; i++)
            parents[i] = i;
        List<Star> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            list.add(new Star(Double.parseDouble(token.nextToken()), Double.parseDouble(token.nextToken())));
        }
        PriorityQueue<Node> que = new PriorityQueue<>();
        for(int i = 0; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                que.add(new Node(Math.sqrt(Math.pow(Math.abs(list.get(i).x-list.get(j).x), 2)+Math.pow(Math.abs(list.get(i).y-list.get(j).y), 2)), i, j));
            }
        }
        double answer = 0;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(find(n.from) != find(n.to)) {
                union(n.from, n.to);
                answer += n.cost;
            }
        }
        System.out.println(String.format("%.2f", answer));
    }
}
