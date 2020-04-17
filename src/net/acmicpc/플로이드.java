package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 플로이드 {
    final static int INF = Integer.MAX_VALUE;
    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] D = new int[N][N];
        int M = sc.nextInt();
        for(int i = 0; i < N; i++) {
            Arrays.fill(D[i], INF);
        }
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int c = sc.nextInt();
            if(D[a][b] != 0) {
                D[a][b] = Math.min(D[a][b], c);
            }
            else {
                D[a][b] = c;
            }
        }
        for (int a = 0; a < N; a++) { // 경유 정점
            for (int b = 0; b < N; b++) { // 출발 정점
                if (a == b) continue;
                for (int c = 0; c < N; c++) { // 도착정점
                    if (a == c || b == c) continue;
                    if (D[b][a] != INF && D[a][c] != INF && D[b][c] > D[b][a] + D[a][c]) {
                        D[b][c] = D[b][a] + D[a][c];
                    }
                }
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(D[i][j] == INF) {
                    System.out.print(0+" ");
                }
                else {
                    System.out.print(D[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}
