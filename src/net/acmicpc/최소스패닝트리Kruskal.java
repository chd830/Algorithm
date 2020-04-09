package net.acmicpc;

import java.util.*;

public class 최소스패닝트리Kruskal {
    static class Edges implements Comparable<Edges>{
        int v1;
        int v2;
        int cost;
        public Edges(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edges o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static int[] parents;
    static int[] rank;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<Edges> edges = new ArrayList<>();
        parents = new int[V];
        rank = new int[V];
        for(int i = 0; i < E; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int c = sc.nextInt();
            edges.add(new Edges(a, b, c));
        }
        Collections.sort(edges);
        parents = new int[V];
        rank = new int[V];
        for(int i = 0; i < V; i++) {
            makeSet(i);
        }
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < E; i++) {
            int a = findSet(edges.get(i).v1);
            int b = findSet(edges.get(i).v2);
            if(a != b) {
                sum += edges.get(i).cost;
                union(a, b);
                if(++cnt == V-1) {
                    break;
                }
            }
        }
        System.out.println(sum);
    }
    static long dist( int x1, int x2, int y1, int y2) {
        return (long)(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }

    static void makeSet(int x) {
        parents[x] = x;
    }
    static int findSet(int x) {
        if( x == parents[x] )
            return x;
        else {
            parents[x] = findSet(parents[x]);
            return parents[x];
        }
    }
    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if( rank[px] > rank[py] ) {
            parents[py] = px;
        }
        else {
            parents[px] = py;
            if( rank[px] == rank[py] ) {
                rank[py]++;
            }
        }
    }
}
