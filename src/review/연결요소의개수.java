package review;

import java.util.*;
import java.io.*;

public class 연결요소의개수 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken())+1;
        M = Integer.parseInt(token.nextToken());
        list = new ArrayList[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(token.nextToken());
            int num2 = Integer.parseInt(token.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }
        int cnt = 0;
        for(int i = 1; i < N; i++) {
            if(!visited[i]) {
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }
    static void dfs(int idx) {
        for(int l : list[idx]) {
            if(!visited[l]) {
                visited[l] = true;
                dfs(l);
            }
        }
    }
}