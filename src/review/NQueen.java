package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
    static int N;
    static int res;
    static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        recur(0);
        System.out.println(res);
    }
    static void recur(int idx) {
        if(idx == N) {
            res++;
            return;
        }
        // 놓을 수 있는 모든 경우의 수
        for(int i = 0; i < N; i++) {
            if(check(idx, i)) {
                map[idx][i] = true;
                recur(idx+1);
                map[idx][i] = false;
            }
        }
    }
    static boolean check(int x, int y) {
        // 위
        for(int i = x; i >= 0; i--) {
            if(map[i][y]) {
                return false;
            }
        }
        // 왼쪽 위
        for(int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if(map[i][j]) {
                return false;
            }
        }
        // 오른족 위
        for(int i = x, j = y; i >= 0 && j < N; i--, j++) {
            if(map[i][j]) {
                return false;
            }
        }
        return true;
    }
}
