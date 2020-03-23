package net.acmicpc;

import java.util.Scanner;

public class 색종이만들기 {
    static int N;
    static int white;
    static int blue;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        blue = 0;
        white = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        check(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
    static boolean isSquare(int x, int y, int size) {
        int criteria = map[x][y];
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(map[i][j] != criteria || visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    static void check(int x, int y, int n) {
        if(isSquare(x, y, n)) {
            if(map[x][y] == 0) {
                white++;
            }
            else {
                blue++;
            }
            return;
        }
        check(x, y, n/2);
        check(x+n/2, y, n/2);
        check(x, y+n/2, n/2);
        check(x+n/2, y+n/2, n/2);
    }
}
