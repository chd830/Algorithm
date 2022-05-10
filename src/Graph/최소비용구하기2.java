package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11779
public class 최소비용구하기2 {
    static class Node implements Comparable<Node> {
        int to;
        int cost;
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cost == o.cost)
                return Integer.compare(this.to, o.to);
            return Integer.compare(this.cost, o.cost);
        }
    }
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        StringTokenizer token = null;
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            list[Integer.parseInt(token.nextToken())].add(new Node(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }
        token = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(token.nextToken());
        int end = Integer.parseInt(token.nextToken());

        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0));
        int[] d = new int[N+1];
        int[] root = new int[N+1];
        Arrays.fill(d, 987654321);
        d[start] = 0;
        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(d[n.to] < n.cost)
                continue;
            for(Node node : list[n.to]) {
                if (d[node.to] > d[n.to] + node.cost) {
                    d[node.to] = d[n.to]+node.cost;
                    que.add(new Node(node.to, n.cost + node.cost));
                    root[node.to] = n.to;
                }
            }
        }
        System.out.println(d[end]);
        List<Integer> list = new ArrayList<>();
        while(end != start) {
            list.add(end);
            end = root[end];
        }
        list.add(end);
        System.out.println(list.size());
        for(int i = list.size()-1; i >= 0; i--)
            System.out.print(list.get(i)+" ");
    }
}
