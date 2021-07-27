package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 1967
public class 트리의지름 {
    static class Node {
        int child;
        int val;
        Node(int child, int val) {
            this.child = child;
            this.val = val;
        }
    }
    static boolean[] visited;
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        StringTokenizer token = null;
        for(int i = 0; i < N-1; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            int n3 = Integer.parseInt(token.nextToken());
            list[n1].add(new Node(n2, n3));
            list[n2].add(new Node(n1, n3));
        }
        visited = new boolean[N + 1];
        Node n = distance(1);
        visited = new boolean[N + 1];
        System.out.println(distance(n.child).val);
    }
    static int max = 0;
    static Node distance(int idx) {
        int num = 0;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(idx, 0));
        visited[idx] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < list[n.child].size(); i++) {
                Node node = list[n.child].get(i);
                if(!visited[node.child]) {
                    int sum = n.val + node.val;
                    que.add(new Node(node.child, sum));
                    if (max < sum) {
                        max = sum;
                        num = node.child;
                    }
                    visited[node.child] = true;
                }
            }
        }
        return new Node(num, max);
    }
}
