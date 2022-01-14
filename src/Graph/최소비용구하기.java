package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1916
public class 최소비용구하기 {
    static int N;
    static int M;
    static int min;
    static int end;
    static int start;
    static List<Node>[] list;
    static PriorityQueue<Node> que;
    static class Node implements Comparable<Node> {
        int to;
        int val;
        Node(int to, int val) {
            this.to = to;
            this.val = val;
        }
        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.val, node.val);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        min = Integer.MAX_VALUE;
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        StringTokenizer token = null;
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int val = Integer.parseInt(token.nextToken());
            list[from].add(new Node(to, val));
        }
        token = new StringTokenizer(br.readLine());
        start = Integer.parseInt(token.nextToken());
        end = Integer.parseInt(token.nextToken());
        que = new PriorityQueue<>();
        que.add(new Node(start, 0));
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(dist[n.to] < n.val)
                continue;
            for(Node node : list[n.to]) {
                if(dist[node.to] > n.val+node.val) {
                    dist[node.to] = n.val + node.val;
                    que.add(new Node(node.to, dist[node.to]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}


