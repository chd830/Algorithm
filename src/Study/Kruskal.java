package Study;

import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int val;
    Edge(int from, int to, int val) {
        this.from = from;
        this.to = to;
        this.val = val;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.val, o.val);
    }
}
public class Kruskal {
    static int[] parent;
    static List<Edge> list;
    public static void main(String[] args) {
        list = new ArrayList<>();
        parent = new int[123456];
        for(int i = 1; i <= parent.length; i++)
            parent[i] = i;
        int sum = 0;
        for(int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);
            if(find(edge.from) == find(edge.to)) {
                sum += edge.val;
                union(edge.from, edge.to);
            }
        }
        System.out.println(sum);
    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y)
            parent[y] = x;
    }
    static int find(int x) {
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
}
