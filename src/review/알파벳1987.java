package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳1987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        max = 0;
        alph[map[0][0]-65]++;
        dfs(0, 0,  1);
        System.out.println(max+1);
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[] alph = new int[26];
    static char[][] map;
    static int max;
    static int N;
    static int M;
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
    static void dfs(int x, int y, int cnt) {
        for(int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if(isIn(dx, dy) && alph[map[dx][dy]-65] < 1) {
                max = Math.max(max, cnt);
                alph[map[dx][dy]-65]++;
                dfs(dx, dy,  cnt+1);
                alph[map[dx][dy]-65]--;
            }
        }
    }
}