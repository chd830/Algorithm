package review;

import java.util.*;
import java.io.*;

// 순열로 접근하는게 아니라 방향으로 이동할 때 이미 방문한 지점을 방문하는지 여부로 체크한다.
public class 미친로봇re {
    static int N;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static double res;
    static double[] arr = new double[4];
    static boolean[][] visited = new boolean[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        // 동 서 남 북
        for(int i = 0; i < 4; i++) {
            arr[i] = Double.parseDouble(token.nextToken()) * 0.01;
        }
        visited[15][15] = true;
        check(15, 15, 0, 1);
        System.out.println(res);
    }
    static void check(int x, int y, int cnt, double rate) {
        if(cnt == N) {
            res += rate;
            return;
        }
        for(int d = 0; d < 4; d++) {
            if(arr[d] == 0) {
                continue;
            }
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if(visited[dx][dy]) {
                continue;
            }
            visited[dx][dy] = true;
            check(dx, dy, cnt+1, rate*arr[d]);
            visited[dx][dy] = false;
        }
    }
}
