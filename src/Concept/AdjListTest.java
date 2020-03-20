package Concept;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjListTest {
    static class Node {
        int to;
        Node link;
        public Node(int to, Node link) {
            super();
            this.to = to;
            this.link = link;
        }
        public Node(int to) {
            super();
            this.to = to;
        }
    }
    static Node[] adjList;
    static int N;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //정점 수
        adjList = new Node[N+1];
        visited = new boolean[N+1];
        int M = sc.nextInt(); //간선 수
        for(int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjList[from] = new Node(to, adjList[from]);
            adjList[to] = new Node(from, adjList[to]);
        }
//        dfs(1);
        bfs(1);
    }
    static void dfs(int cur) {
        visited[cur] = true;
        System.out.println((char)(cur+64));
        for(Node n = adjList[cur]; n != null; n = n.link) {
            if(!visited[n.to]) {
                dfs(n.to);
            }
        }
    }
    static void bfs(int cur) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(cur, adjList[cur]));
        System.out.println((char)(cur+64));
        visited[cur] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(;n != null; n = n.link) {
                if(!visited[n.to]) {
                    visited[n.to] = true;
                    System.out.println((char)(n.to+64));
                    que.add(new Node(n.to, adjList[n.to]));
                }
            }
        }
    }
}
