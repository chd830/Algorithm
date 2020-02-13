package net.acmicpc;

import java.util.Scanner;

public class 달이차오른다가자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] map = new char[N][M];

        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
    }
}
