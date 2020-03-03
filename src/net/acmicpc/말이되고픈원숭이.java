package net.acmicpc;

import java.util.Scanner;

//움직일 수 있는 걸 말이랑 원숭이를 같이 생각하고...말처럼 움직일 수 있는 횟수를 카운팅한다.
public class 말이되고픈원숭이 {
    static int N;
    static int H;
    static int max;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        max = 0;
        N = sc.nextInt();
        H = sc.nextInt();
        map = new int[N][H];
        visited = new boolean[N][H];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < H; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0, K, 0);
        System.out.println(max);
    }
    static int[][] move = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static void dfs(int x, int y, int K, int cnt) {
        if(K <= 0) {
            return;
        }
        if(x == N && y == H) {
            return;
        }
        for(int i = 0; i < move.length; i++) {
            int dx = x + move[i][0];
            int dy = y + move[i][1];
            if(dx >= 0 && dy >= 0 && dx < N && dy < H && !visited[dx][dy]) {
                visited[dx][dy] = true;
                max = Math.max(max, cnt);
                if(i < 8) {
                    dfs(dx, dy, K-1, cnt+1);
                }
                else {
                    dfs(dx, dy, K, cnt+1);
                }
                visited[dx][dy] = false;
            }
        }
    }
}
