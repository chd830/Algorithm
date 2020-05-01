package net.acmicpc;

import java.util.Scanner;

public class 치킨배달 {
    static class Node {
        int x;
        int y;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) {

                }
            }
        }

    }
}
