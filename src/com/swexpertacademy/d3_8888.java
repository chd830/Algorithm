package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//시험
public class d3_8888 {
    //    public static void main(String[] args) {
    public d3_8888() {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int N = sc.nextInt();
            int T = sc.nextInt();
            int P = sc.nextInt();
            int[][] arr = new int[N][T];
            int[][] result = new int[N][3];
            int[] score = new int[N];
            int[] sum = new int[N];
            int[] rank = new int[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < T; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println("#" + t + " " + result[P - 1][1] + " " + result[P - 1][2]);
        }
    }

    static void print(int i, int N, int[][] result) {
        for (int k = 0; k < N; k++) {
            System.out.print(result[k][i] + " ");
        }
        System.out.println();
    }
}
