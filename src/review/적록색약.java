package review;

import java.util.*;
import java.io.*;

public class 적록색약 {
    static boolean[][] visited1;
    static boolean[][] visited2;
    static char[][] map;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int cnt1;
    static int cnt2;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited1[i][j]) {
                    visited1[i][j] = true;
                    cnt1++;
                    dfs(i, j, map[i][j]);
                }
                if(!visited2[i][j]) {
                    visited2[i][j] = true;
                    cnt2++;
                    weak(i, j, map[i][j]);
                }
            }
        }
        System.out.println(cnt1+" "+cnt2);
    }
    public static void weak(int x, int y, char c) {
        for(int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if(dx >= 0 && dy >= 0 && dx < N && dy < N && !visited2[dx][dy]) {
                switch (c) {
                    case 'R': case 'G':
                        if(map[dx][dy] == 'G' || map[dx][dy] == 'R') {
                            visited2[dx][dy] = true;
                            weak(dx, dy, map[dx][dy]);
                        }
                        break;
                    case 'B':
                        if(map[dx][dy] == 'B') {
                            visited2[dx][dy] = true;
                            weak(dx, dy, map[dx][dy]);
                        }

                }
            }
        }
    }
    public static void dfs(int x, int y, char c) {
        for(int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if(dx >= 0 && dy >= 0 && dx < N && dy < N && !visited1[dx][dy]) {
                if(map[dx][dy] == c) {
                    visited1[dx][dy] = true;
                    dfs(dx, dy, map[dx][dy]);
                }
            }
        }
    }
}
