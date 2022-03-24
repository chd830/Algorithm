package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1916
public class 최소비용구하기 {
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
    static int N;
    static int M;
    static int start;
    static int end;
    static int[] dist;
    static List<Node>[] list;
    static PriorityQueue<Node> que;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer token = null;
        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            list[Integer.parseInt(token.nextToken())].add(new Node(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }
        token = new StringTokenizer(br.readLine());
        start = Integer.parseInt(token.nextToken());
        end = Integer.parseInt(token.nextToken());
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0));
        while(!que.isEmpty()) {
            Node node = que.poll();
            if(dist[node.idx] < node.weight)
                continue;
            for(Node n : list[node.idx]) {
                if(dist[n.idx] > node.weight+n.weight) {
                    dist[n.idx] = node.weight+n.weight;
                    que.add(new Node(n.idx, dist[n.idx]));
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
/*
7
12
1 2 7
1 5 3
1 6 10
5 2 2
2 6 6
2 3 4
2 4 10
5 7 5
5 4 11
3 4 2
6 4 9
7 4 4
 */