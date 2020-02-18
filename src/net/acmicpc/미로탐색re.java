package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 미로탐색re {
    static int N;
    static int M;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N+2][M+2];
        /*
        map = new int[N+2][M+2]로 하면
        0이 벽이기 때문에 배열 범위 검사를 해줄 필요가 없어진다.
         */
        for(int i = 1; i <= N; i++) {
            String str = sc.next();
            for(int j = 0; j < str.length(); j++) {
                map[i][j+1] = str.charAt(j) - '0';
            }
        }
        for(int i = 0; i < N+2; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
    public static void dfs(int x, int y) {
        map[x][y] = 1;

    }
    public static void bfs() {

    }
}
