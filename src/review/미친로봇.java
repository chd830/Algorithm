package review;

import java.util.*;
import java.io.*;

public class 미친로봇 {
    static int N;
    static double ans;
    static double[] percentages = new double[4];
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] visited = new boolean[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        ans = 0;
        for(int i = 0; i < 4; i++) {
            percentages[i] = Double.parseDouble(token.nextToken()) * 0.01;
        }
        visited[15][15] = true;
        dfs(15, 15, 0, 1);
        System.out.println(ans);
    }
    static void dfs(int x, int y, int cnt, double result) {
        if(cnt == N) {
            ans += result;
            return;
        }
        for(int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if(dx >= 0 && dy >= 0 && dx < 30 && dy < 30 && !visited[dx][dy]) {
                visited[dx][dy] = true;
                dfs(dx, dy, cnt+1, result*percentages[d]);
                visited[dx][dy] = false;
            }
        }

    }
}
