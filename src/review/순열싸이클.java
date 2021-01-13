package review;

import java.util.*;
import java.io.*;

public class 순열싸이클 {
    static int cnt;
    static boolean[] visited;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++ ) {
            cnt = 0;
            int N = Integer.parseInt(br.readLine());
            visited = new boolean[N+1];
            list = new ArrayList[N+1];
            for(int i = 0; i <= N; i++) {
                list[i] = new ArrayList<>();
            }
            token = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                int n = Integer.parseInt(token.nextToken());
                list[i].add(n);
                list[n].add(i);
            }
            for(int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    cnt++;
                    visited[i] = true;
                    check(i);
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    static void check(int idx) {
        for(int i : list[idx]) {
            if(!visited[i]) {
                visited[i] = true;
                check(i);
            }
        }
    }
}
