package net.acmicpc;

import java.util.Scanner;

public class NQueenre {
    static int cnt;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        cnt = 0;
        map = new int[N][N];
        setQueen(0, N);
        System.out.println(cnt);
    }
    public static void setQueen(int idx, int N) {
        if(idx == N) {
            cnt++;
            return;
        }
        for(int i = 0; i < N; i++) {
            if(isPossible(idx, i)) {
                map[idx][i] = 1;
                setQueen(idx+1, N);
                map[idx][i] = 0;
            }
        }
    }
    public static void print() {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map.length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean isPossible(int x, int y) {
        for(int i = x; i >= 0; i--) {
            if(map[i][y] == 1) {
                return false;
            }
        }
        for(int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if(map[i][j] == 1) {
                return false;
            }
        }
        for(int i = x, j = y; i >= 0 && j < map.length; i--, j++) {
            if(map[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
