package com.swexpertacademy;

import java.util.Scanner;

//숫자 배열 회전
public class d2_1961 {
//    public static void main(String[] args) {
    public d2_1961() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int[][] r = rotate(arr);
            print(r);
//            System.out.println("#"+t+" ");
        }
    }
    static void print(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.print(" ");
        }
    }

    public static int[][] rotate(int[][] arr) {
        int[][] r = new int[arr.length][arr.length];
        for(int i = 0, k = arr.length - 1; i < arr.length; i++, k--) {
            for(int j = 0; j < arr.length; j++) {
                r[j][k] = arr[i][j];
            }
        }
        return r;
    }
}
