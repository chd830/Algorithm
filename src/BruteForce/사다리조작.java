package BruteForce;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/15684
public class 사다리조작 {
    static int N;
    static int M;
    static int H;
    static int answer = 4;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        H = Integer.parseInt(token.nextToken());
        map = new int[H+1][N+1];
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            // 1: 오른쪽으로 이동
            // 2: 왼쪽으로 이동
            map[x][y] = 1;
            map[x][y+1] = 2;
        }
        dfs(1, 0);
        System.out.println(answer != 4 ? answer : -1);
    }
    static void dfs(int x, int cnt) {
        if(answer <= cnt)
            return;
        if (check()) {
            answer = cnt;
            return;
        }
        for(int i = x; i < H+1; i++) {
            for(int j = 1; j < N; j++) {
                if(map[i][j] == 0 && map[i][j+1] == 0) {
                    map[i][j] = 1;
                    map[i][j+1] = 2;
                    dfs(i, cnt+1);
                    map[i][j] = map[i][j+1] = 0;
                }
            }
        }
    }
    static boolean check() {
        // 1번 사다리부터 연결을 체크하면서
        for(int i = 1; i <= N; i++) {
            int x = 1;
            int y = i;
            for(int j = 0; j < H ; j++) {
                if(map[x][y] == 1)
                    y++;
                else if(map[x][y] == 2)
                    y--;
                x++;
            }
            // 오른쪽으로 이동한 값과 왼쪽으로 이동한 값이 같은지 확인
            if(y != i)
                return false;
        }
        return true;
    }
}
