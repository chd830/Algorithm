package net.acmicpc;

import java.util.Scanner;

public class 로봇청소기 {
    static int N;
    static int M;
    static int d;
    static int cnt;
    static int turn;
    static int startX;
    static int startY;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cnt = 0;
        turn = 0;
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        startX = sc.nextInt();
        startY = sc.nextInt();
        d = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        solution();
    }
    static void solution() {
        while(true) {
            //네 방향이 모두 청소가 되어있거나 벽일 때는 뒤로간다.
            if(turn == 4) {
                int dx = startX - dir[d][0];
                int dy = startY - dir[d][1];

                //벽을 만날을 때 종료
                if(map[dx][dy] == 1) {
                    System.out.println(count());
                    return;
                }
                else {
                    startX = dx;
                    startY = dy;
                    turn = 0;
                }
            }
            //청소
            if(map[startX][startY] == 0) {
                map[startX][startY] = 2;
            }
            //왼쪽방향 확인
            int left = (d+3) % 4;
            int dx = startX + dir[left][0];
            int dy = startY + dir[left][1];
            //청소
            if(map[dx][dy] == 0) {
                startX = dx;
                startY = dy;
                d = left;
                turn = 0;
            }
            //청소못함. 회전
            else {
                d = left;
                turn++;
            }
        }
    }
    static int count() {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 2) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
