package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇청소기 {
    static int r;
    static int c;
    static int N;
    static int M;
    static int cnt;
    static int turn;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];
        token = new StringTokenizer(br.readLine());
        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());
        int pos = Integer.parseInt(token.nextToken());
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        while(true) {
            if(turn == 4) {
                int dx = r - dir[pos][0];
                int dy = c - dir[pos][1];
                //뒤쪽 방향이 벽이라 후진할 수 없는 경우
                if(map[dx][dy] == 1) {
                    count();
                    System.exit(0);
                }
                //후진
                else {
                    r = dx;
                    c = dy;
                    turn = 0;
                }
            }
            if(map[r][c] == 0) {
                map[r][c] = 2;
            }
            int left = (pos+3)%4;
            int dx = r + dir[left][0];
            int dy = c + dir[left][1];
            if(map[dx][dy] == 0) {
                r = dx;
                c = dy;
                pos = left;
                turn = 0;
            }
            else {
                pos = left;
                turn++;
            }
        }
    }
    static void count() {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 2) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
