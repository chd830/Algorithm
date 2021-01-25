package review;

import java.util.*;
import java.io.*;

public class 트리의지름1167 {
    static class Node {
        int n;
        int dist;
        Node(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }
    }
    static int N;
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer token;
        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken());
            int m = 0;
            while((m = Integer.parseInt(token.nextToken())) != -1) {
                int l = Integer.parseInt(token.nextToken());
                list[n].add(new Node(m, l));
                list[m].add(new Node(n, l));
            }
        }
        Node n = getNode(1);
        System.out.println(getNode(n.n).dist);
    }
    static Node getNode(int idx) {
        int maxNode = 0;
        int max = 0;
        boolean[] visited = new boolean[N+1];
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(idx, 0));
        visited[idx] = true;
        while(!que.isEmpty()) {
            Node q = que.poll();
            for(Node node : list[q.n]) {
                if(!visited[node.n]) {
                    visited[node.n] = true;
                    que.add(new Node(node.n, q.dist+node.dist));
                    if(max < q.dist+node.dist) {
                        maxNode = node.n;
                        max = q.dist+node.dist;
                    }
                }
            }
        }
        return new Node(maxNode, max);
    }
}
