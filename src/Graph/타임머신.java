package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11657
public class 타임머신 {
    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int M;
    static long[] d;
    static Node[] list;
    static class Node {
        int x;
        int y;
        int val;
        Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        list = new Node[M];
        d = new long[N+1];
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            int val = Integer.parseInt(token.nextToken());
            list[i] = new Node(x, y, val);
        }
        StringBuilder sb = new StringBuilder();
        Arrays.fill(d, INF);
        d[1] = 0;
        if(!bellmanFord()) {
            for(int i = 2; i <= N; i++)
                sb.append(d[i] == INF ? "-1\n" : d[i]+"\n");
        }
        else
            sb.append("-1\n");
        System.out.println(sb.toString());
    }
    static boolean bellmanFord() {
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < M; j++) {
                int cur = list[j].x;
                int next = list[j].y;
                int val = list[j].val;
                if(d[cur] == INF)
                    continue;
                if(d[next] > d[cur]+val) {
                    d[next] = d[cur]+val;
                }
            }
        }
        for(int i = 0; i < M; i++) {
            if(d[list[i].x] == INF)
                continue;
            if(d[list[i].x]+list[i].val < d[list[i].y])
                return true;
        }
        return false;
    }
}