package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1717
public class 집합의표현 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        StringBuilder sb = new StringBuilder();
        parent = new int[N+1];
        for(int i = 1; i <= N; i++)
            parent[i] = i;
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(token.nextToken());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            if(command == 0) {
                union(n1, n2);
            }
            else {
                if(find(n1) != find(n2))
                    sb.append("NO").append("\n");
                else
                    sb.append("YES").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static int find(int x) {
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) {
            if(x < y)
                parent[y] = x;
            else
                parent[x] = y;
        }
    }
}
