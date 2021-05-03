package review;

import java.util.*;
import java.io.*;

// 두 동전
public class acmicpc16197 {
    static int N;
    static int M;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static class Node {
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        int dx1 = -1;
        int dy1 = 0;
        int dx2 = -1;
        int dy2 = 0;
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'o') {
                    visited[i][j] = true;
                    if(dx1 == -1) {
                        dx1 = i;
                        dy1 = j;
                    }
                    else {
                        dx2 = i;
                        dy2 = j;
                    }
                }
                else if(map[i][j] == '#') {
                    visited[i][j] = true;
                }
            }
        }
        dfs(dx1, dy1, dx2, dy2, 0);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
    static int res = Integer.MAX_VALUE;
    static void dfs(int x1, int y1, int x2, int y2, int cnt) {
        if(cnt >= res || cnt >= 10)
            return;
        int dx1, dy1, dx2, dy2;
        boolean c1, c2;
        for(int d = 0; d < 4; d++) {
            dx1 = x1 + dir[d][0];
            dy1 = y1 + dir[d][1];
            dx2 = x2 + dir[d][0];
            dy2 = y2 + dir[d][1];

            c1 = check(dx1, dy1);
            c2 = check(dx2, dy2);

            if(c1 && c2)
                continue;
            if(c1 || c2) {
                res = Math.min(cnt+1, res);
                return;
            }
            if(!c1 && map[dx1][dy1] == '#') {
                dx1 = x1;
                dy1 = y1;
            }
            if(!c2 && map[dx2][dy2] == '#') {
                dx2 = x2;
                dy2 = y2;
            }
            if((dx1 == dx2) && (dy1 == dy2))
                continue;
            dfs(dx1, dy1, dx2, dy2, cnt+1);
        }
    }
    static boolean check(int x, int y) {
        return !(x >= 0 && x < N && y >= 0 && y < M);
    }
}
