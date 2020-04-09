package net.acmicpc;

import java.util.*;

public class 최소스패닝트리Prim {
    static class Edge {
        int target;
        int val;
        Edge(int target, int val) {
            this.target = target;
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<Edge>[] graph = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int c = sc.nextInt();
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }
        boolean[] check = new boolean[V];
        int[] direction = new int[V];
        Arrays.fill(direction, Integer.MAX_VALUE);
        int start = 0;
        int result = 0;
        check[start] = true;
        direction[start] = 0;
        while(true) {
            for(int i = 0; i < graph[start].size(); i++) {
                int target = graph[start].get(i).target;
                int val = graph[start].get(i).val;
                if(!check[target] && direction[target] > val) {
                    direction[target] = val;
                }
            }
            int min = Integer.MAX_VALUE;
            boolean isEnd = true;
            for(int i = 0; i < direction.length; i++) {
                if(check[i] || direction[i] == Integer.MAX_VALUE) {
                    continue;
                }
                if(direction[i] < min) {
                    min = direction[i];
                    start = i;
                    isEnd = false;
                }
            }
            if(isEnd) {
                break;
            }
            check[start] = true;
            result += min;
        }
        System.out.println(result);
    }
}
