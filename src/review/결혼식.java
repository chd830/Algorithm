package review;

import java.util.*;
import java.io.*;

//5567
public class 결혼식 {
    static int N;
    static int M;
    static int num;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer token;
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(token.nextToken());
            int num2 = Integer.parseInt(token.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }
        visited = new boolean[N+1];
        dfs(1, 0);
        System.out.println(num);
    }
    static boolean[] visited;
    static void dfs(int idx, int cnt) {
        if(cnt > 2) {
            return;
        }
        else if(idx != 1 && !visited[idx]) {
            visited[idx] = true;
            num++;
        }
        for(int i : list[idx]) {
            dfs(i, cnt+1);
        }
    }
}
