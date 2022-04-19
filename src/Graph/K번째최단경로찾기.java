package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1854
public class K번째최단경로찾기 {
    static List<Node>[] list;
    static PriorityQueue<Integer>[] d;
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        list = new ArrayList[N+1];
        d = new PriorityQueue[N+1];
        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
            d[i] = new PriorityQueue<>();
        }
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            int val = Integer.parseInt(token.nextToken());
            list[n1].add(new Node(n2, val));
        }

        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(1, 0));
        d[1].add(0);
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(Node node : list[n.x]) {
                // K보다 작을 때는 음수로 값을 기록
                if(d[node.x].size() < K) {
                    d[node.x].add((n.val+node.val)*-1);
                    que.add(new Node(node.x, n.val+node.val));
                }
                // 현재 값이 저장되어 있는 값보다 작으면 큰 값을 삭제하고 새로운 값을 넣음
                else if(d[node.x].peek()*-1 > n.val+node.val) {
                    d[node.x].poll();
                    d[node.x].add((n.val+node.val)*-1);
                    que.add(new Node(node.x, n.val+node.val));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if (d[i].size() == K)
                sb.append(d[i].poll()*-1).append("\n");
            else
                sb.append(-1).append("\n");
        }
        System.out.println(sb.toString());
    }
}
