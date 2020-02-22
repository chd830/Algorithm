package net.acmicpc;

import java.util.Scanner;

public class 체스판다시칠하기 {
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;
    static char[][] map;
    static char[][] chess1 = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}};
    static char[][] chess2 = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for(int i = 0; i <= N-8; i++) {
            for(int j = 0; j <= M-8; j++) {
                min = Math.min(check(i, j, chess1), min);
                min = Math.min(check(i, j, chess2), min);
            }
        }
        System.out.println(min);
    }
    public static int check(int x, int y, char[][] chess) {
        int count = 0;
        for(int i = x, dx = 0; i < x+8; i++, dx++) {
            for(int j = y, dy = 0; j < y+8; j++, dy++) {
                if(map[i][j] != chess[dx][dy]) {
                    count++;
                }
            }
        }
        return count;
    }
}
