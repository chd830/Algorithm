package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE13023 {
    static int N;
    static List<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        arr = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            arr[i] = new ArrayList();
        }
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        ans = false;
        visited = new boolean[N];
        for(int i =0; i < N; i++) {
            dfs(i, 1);
        }
        System.out.println(ans ? 1 : 0);
    }
    static boolean ans;
    static boolean[] visited;
    static void dfs(int num, int cnt) {
        if(cnt == 5) {
            ans = true;
            return;
        }
        visited[num] = true;
        for(int next : arr[num]) {
            if(!visited[next]) {
                dfs(next, cnt+1);
                if(ans) {
                    return;
                }
            }
        }
        visited[num] = false;
    }
}
