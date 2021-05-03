package review;

import java.util.*;
import java.io.*;

// 파이프 옮기기 1
public class acmicpc17070 {
    static int N;
    static int res = 0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        dfs(0, 1, 0);
        System.out.println(res);
    }
    static int[][] dir = {{0, 1}, {1, 0}, {1, 1}};
    static void dfs(int x, int y, int cur) {
        if(x == N-1 && y == N-1) {
            res++;
            return;
        }
        for(int d = 0; d < 3; d++) {
            if((cur == 0 && d == 1) || (cur == 1 && d == 0))
                continue;
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if(dx >= N || dy >= N || map[dx][dy] == 1)
                continue;
            if(d == 2) {
                if(map[x+1][y] == 1 || map[x][y+1] == 1)
                    continue;
            }
            dfs(dx, dy, d);
        }
    }
}
