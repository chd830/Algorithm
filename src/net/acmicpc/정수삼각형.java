package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 정수삼각형 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] tri = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                tri[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    tri[i][j] += tri[i-1][j];
                }
                else if(j == i) {
                    tri[i][j] += tri[i-1][j-1];
                }
                else {
                    tri[i][j] += Math.max(tri[i-1][j], tri[i-1][j-1]);
                }
                max = Math.max(tri[i][j], max);
            }
        }
        System.out.println(max);
    }
}