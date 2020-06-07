package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 욕심쟁이판다1937 {
    static int N;
    static int max;
    static int[][] map;
    static int[][] cnt;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        cnt = new int[N][N];
        max = 0;
        StringTokenizer token;
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }
        System.out.println(max);
    }

    static int dfs(int x, int y) {
        if (cnt[x][y] != 0) {
            return cnt[x][y];
        }
        cnt[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            if (dx >= 0 && dy >= 0 && dx < N && dy < N) {
                if (map[x][y] < map[dx][dy]) {
                    cnt[x][y] = Math.max(cnt[x][y], dfs(dx, dy) + 1);
                }

            }
        }
        return cnt[x][y];
    }
}
