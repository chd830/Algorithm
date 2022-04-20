package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1865
public class 웜홀 {
    static final int INF = 1234567;
    static class Node {
        int x;
        int val;
        Node(int x, int val) {
            this.x = x;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            W = Integer.parseInt(token.nextToken());
            list = new ArrayList[N+1];
            for(int i = 0; i <= N; i++)
                list[i] = new ArrayList<>();
            // 도시의 개수
            for(int i = 0; i < M; i++) {
                token = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(token.nextToken());
                int end = Integer.parseInt(token.nextToken());
                int time = Integer.parseInt(token.nextToken());
                list[start].add(new Node(end, time));
                list[end].add(new Node(start, time));
            }
            // 웜홀의 개수
            for(int i = 0; i < W; i++) {
                token = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(token.nextToken());
                int end = Integer.parseInt(token.nextToken());
                int time = Integer.parseInt(token.nextToken());
                list[start].add(new Node(end, -time));
            }
            d = new int[N+1];
            boolean flag = false;
            for(int i = 1; i <= N; i++) {
                if(bellmanFord(i)) {
                    flag = true;
                    sb.append("YES\n");
                    break;
                }
            }
            if(!flag)
                sb.append("NO\n");
        }
        System.out.println(sb.toString());
    }
    static int[] d;
    static int N;
    static int M;
    static int W;
    static List<Node>[] list;
    static boolean bellmanFord(int start) {
        Arrays.fill(d, INF);
        d[start] = 0;
        boolean flag = false;
        for(int i = 1; i < N; i++) {
            flag = false;
            for(int j = 1; j <= N; j++) {
                for(Node n : list[j]) {
                    if(d[j] != INF && d[n.x] > d[j]+n.val) {
                        d[n.x] = d[j]+n.val;
                        flag = true;
                    }
                }
            }
            if(!flag)
                break;
        }
        if(flag) {
            for(int i = 1; i <= N; i++) {
               for(Node n : list[i]) {
                   if(d[i] != INF && d[n.x] > d[i]+n.val)
                       return true;
               }
            }
        }
        return false;
    }
}
