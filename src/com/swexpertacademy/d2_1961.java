package com.swexpertacademy;

import java.util.Scanner;

//숫자 배열 회전
public class d2_1961 {
    //    public static void main(String[] args) {
    public d2_1961() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            String[][] result = new String[N][N];
            int[][] r = new int[N][N];
            r = rotate(arr);
            swap(result, r, 0);
            r = rotate(r);
            swap(result, r, 1);
            r = rotate(r);
            swap(result, r, 2);
            System.out.println("#" + t);
            print(result);
        }
    }

    static void swap(String[][] strs, int[][] arr, int pos) {
        for (int i = 0, k = 0; i < arr.length; i++, k++) {
            String str = "";
            strs[k][pos] = "";
            for (int j = 0; j < arr.length; j++) {
                str += arr[i][j];
            }
            strs[k][pos] = str;
        }
    }

    static void print(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] rotate(int[][] arr) {
        int[][] r = new int[arr.length][arr.length];
        for (int i = 0, k = arr.length - 1; i < arr.length; i++, k--) {
            for (int j = 0; j < arr.length; j++) {
                r[j][k] = arr[i][j];
            }
        }
        return r;
    }
}
