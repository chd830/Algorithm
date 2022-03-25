package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1167
public class 트리의지름 {
    static int V;
    static List<Node>[] list;
    static class Node {
        int idx;
        int val;
        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        for(int i = 0; i <= V; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            while(n2 != -1) {
                int val = Integer.parseInt(token.nextToken());
                list[n1].add(new Node(n2, val));
                n2 = Integer.parseInt(token.nextToken());
            }
        }
        visited = new boolean[V+1];
        visited[1] = true;
        findMax(1, 0);
        visited = new boolean[V+1];
        visited[maxIdx] = true;
        findMax(maxIdx, 0);
        System.out.println(max);
    }
    static int max;
    static int maxIdx;
    static boolean[] visited;
    static void findMax(int idx, int cnt) {
        if(max < cnt) {
            max = cnt;
            maxIdx = idx;
        }
        for(Node n : list[idx]) {
            if(!visited[n.idx]) {
                visited[n.idx] = true;
                findMax(n.idx, cnt+n.val);
                visited[n.idx] = false;
            }
        }
    }
}
