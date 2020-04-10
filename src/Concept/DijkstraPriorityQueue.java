package Concept;

import java.util.*;

public class DijkstraPriorityQueue {
    static class Edge implements Comparable<Edge> {
        int v;
        int weight;
        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<Edge>[] adj = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList();
        }
        for(int i = 0; i < E; i++) {
            adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
        }

        //dijkstra
        PriorityQueue<Edge> que = new PriorityQueue<>();
        boolean[] check = new boolean[V];
        Edge[] D = new Edge[V];

        //0번에서 출발하는 것으로 가정
        for(int i = 0; i < V; i++) {
            if(i == 0) {
                D[i] = new Edge(i, 0);
            }
            else {
                D[i] = new Edge(i, Integer.MAX_VALUE);
            }
            que.add(D[i]);
        }
        while(!que.isEmpty()) {
            Edge edge = que.poll();
            //check되지 않았으면서 D[next.v]가 D[edge.v]+next.weight보다 크면 갱신
            for(Edge next : adj[edge.v]) {
                if(!check[next.v] && D[next.v].weight > D[edge.v].weight+next.weight) {
                    D[next.v].weight = D[edge.v].weight + next.weight;
                    //뺏다가 다시 넣어서 위치를 조정한다.
                    que.remove(D[next.v]);
                    que.add(D[next.v]);
                }
            }
            check[edge.v] = true;
        }
        System.out.println(Arrays.toString(D));
    }
}
