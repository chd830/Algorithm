package Graph;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1707
public class 이분그래프 {
    // R, B 두가지색으로 인접한 정점끼리 다른색을 칠할 수 있는 그래프
    static List<Integer>[] list;
    static int V;
    static int E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        loop: for(int num = 0; num < N; num++) {
            token = new StringTokenizer(br.readLine());
            V = Integer.parseInt(token.nextToken());
            E = Integer.parseInt(token.nextToken());
            list = new ArrayList[V + 1];
            for (int i = 0; i <= V; i++)
                list[i] = new ArrayList<>();
            for (int i = 0; i < E; i++) {
                token = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(token.nextToken());
                int n2 = Integer.parseInt(token.nextToken());
                list[n1].add(n2);
                list[n2].add(n1);
            }
            int[] color = new int[V+1];
            boolean flag = true;
            // 색칠하기
            for(int i  = 1; i <= V; i++) {
                if(color[i] == 0)
                    dfs(color, i, 1);
            }
            // 연결된 정점들을 탐색하면서 이분그래프의 조건이 되는지 확인
            for(int i = 1; i <= V; i++) {
                for(int l : list[i]) {
                    if(color[i] == color[l])
                        flag = false;
                }
            }
            if(flag)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int[] color, int x, int c) {
        color[x] = c;
        for(int l : list[x]) {
            if(color[l] == 0)
                dfs(color, l, 3-c);
        }
    }
}
