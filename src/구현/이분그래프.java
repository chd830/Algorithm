package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1707
public class 이분그래프 {
    static int V;
    static int[] order;
    static List<Integer>[] list;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            V = Integer.parseInt(token.nextToken());
            int E = Integer.parseInt(token.nextToken());
            list = new ArrayList[V + 1];
            for (int i = 0; i <= V; i++)
                list[i] = new ArrayList<>();
            for (int i = 0; i < E; i++) {
                token = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(token.nextToken());
                int n2 = Integer.parseInt(token.nextToken());
                if(n1 == n2)
                    continue;
                list[n1].add(n2);
                list[n2].add(n1);
            }
            fill();
        }
        System.out.println(sb.toString());
    }
    static void fill() {
        Queue<Integer> que = new LinkedList<>();
        order = new int[V+1];
        for(int i = 1; i <= V; i++) {
            if(order[i] == 0) {
                que.add(i);
                order[i] = 1;
            }
            while(!que.isEmpty()) {
                int n = que.poll();
                for(int l : list[n]) {
                    if(order[l] == order[n]) {
                        sb.append("NO\n");
                        return;
                    }
                    if(order[n] == 1 && order[l] == 0) {
                        order[l] = 2;
                        que.add(l);
                    }
                    else if(order[n] == 2 && order[l] == 0) {
                        order[l] = 1;
                        que.add(l);
                    }
                }
            }
        }
        sb.append("YES\n");
    }
}

