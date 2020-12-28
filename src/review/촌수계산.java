package review;

import java.io.*;
import java.util.StringTokenizer;

public class 촌수계산 {
    static int N;
    static int res;
    static int start;
    static int end;
    static int[][] maps;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        res = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine())+1;
        StringTokenizer token = new StringTokenizer(br.readLine());
        start = Integer.parseInt(token.nextToken());
        end = Integer.parseInt(token.nextToken());
        maps = new int[N][N];
        visited = new boolean[N];
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            token = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(token.nextToken());
            int num2 = Integer.parseInt(token.nextToken());
            maps[num1][num2] = 1;
            maps[num2][num1] = 1;
        }
        dfs(start, 0);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
    static void dfs(int idx, int cnt) {
        if(idx == end) {
            res = Math.min(res, cnt);
            return;
        }
        for(int i = 0; i < N; i++) {
            if(maps[idx][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, cnt+1);
                visited[i] = false;
            }
        }
    }
}
