package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dfs로 탐색하기
public class 미친로봇1405 {
    static int N;
    static double ans;
    static double[] dir = new double[4];
    static boolean[][] visited = new boolean[30][30];
    //방향이 동서남북으로 진행됨
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        for (int i = 0; i < 4; i++) {
            dir[i] = Integer.parseInt(token.nextToken()) * 0.01;
        }
        visited[14][14] = true;
        dfs(14, 14, 0, 1.0);
        System.out.println(ans);
    }

    static void dfs(int x, int y, int cnt, double percent) {
        //이동거리가 끝남.
        if (cnt == N) {
            ans += percent;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (dir[i] == 0) {
                continue;
            }
            int dx = x + direction[i][0];
            int dy = y + direction[i][1];
            if(visited[dx][dy]) {
                continue;
            }
            visited[dx][dy] = true;
            //로봇이 지나간 길을 체크하고 확률을 곱한다.
            dfs(dx, dy, cnt + 1, percent * dir[i]);
            visited[dx][dy] = false;
        }
    }
}
