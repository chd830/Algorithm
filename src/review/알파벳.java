package review;

import java.util.*;
import java.io.*;

public class 알파벳 {
    static int N;
    static int M;
    static int max;
    static char[][] map;
    static boolean[] check = new boolean[26];
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        visited[0][0] = true;
        check[map[0][0]-65] = true;
        recur(0, 0, 1);
        System.out.println(max);
    }
    static void recur(int x, int y, int cnt) {
        max = Math.max(max, cnt);
        for(int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if(dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy] && !check[map[dx][dy]-65]) {
                check[map[dx][dy]-65] = true;
                visited[dx][dy] = true;
                recur(dx, dy, cnt+1);
                check[map[dx][dy]-65] = false;
                visited[dx][dy] = false;
            }
        }
    }
}
