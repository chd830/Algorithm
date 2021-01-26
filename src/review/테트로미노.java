package review;

import java.io.*;
import java.util.*;

public class 테트로미노 {
    static int N;
    static int M;
    static int max;
    static int[][] map;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] ex = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    static int[][] ey = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        max = 0;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                recur(i, j, 1, map[i][j]);
                // 방문을 체크하고 시작한 후 방문 해제를 체크하는 것 잊지말기
                visited[i][j] = false;
                // ㅏ, ㅜ, ㅓ, ㅗ 모양은 dir배열로 접근할 수 없으므로 다른 배열을 선언하여 따로 계산해줘야 한다.
                exception(i, j);
            }
        }
        System.out.println(max);
    }
    static void recur(int x, int y, int cnt, int sum) {
        if(cnt == 4) {
            max = Math.max(max, sum);
            return;
        }
        for(int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if(isIn(dx, dy) && !visited[dx][dy]) {
                visited[dx][dy] = true;
                recur(dx, dy, cnt+1, sum+map[dx][dy]);
                visited[dx][dy] = false;
            }
        }
    }
    static void exception(int x, int y) {
        for(int i = 0; i < ex.length; i++) {
            boolean check = true;
            int sum = 0;
            for(int j = 0; j < ex[0].length; j++) {
                int dx = x + ex[i][j];
                int dy = y + ey[i][j];
                if(!isIn(dx, dy)) {
                    check = false;
                }
                else {
                    sum += map[dx][dy];
                }
            }
            if(check) {
                max = Math.max(max, sum);
            }
        }
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
