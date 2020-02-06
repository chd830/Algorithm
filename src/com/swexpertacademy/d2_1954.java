package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//달팽이 숫자
public class d2_1954 {
    public d2_1954() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int num = sc.nextInt();
            int[][] arr = new int[num][num];
            boolean[][] visited = new boolean[num][num];
            int r = 0;
            int c = 0;
            int count = 1;

            int i = 0;
            int j = 0;
            while(true) {
                for(i = 0; i < num; i++) {
                    if(!visited[j][i]) {
                        arr[j][i] = count++;
                        visited[j][i] = true;
                    }
                }
                i--;
                System.out.println();
                print(arr);
                print(visited);
                for(j = 0; j < num; j++) {
                    if(!visited[j][i]) {
                        arr[j][i] = count++;
                        visited[j][i] = true;
                    }
                }
                j--;
                System.out.println();
                print(arr);
                print(visited);
                for(; i >= 0; i--) {
                    if(!visited[j][i]) {
                        arr[j][i] = count++;
                        visited[j][i] = true;
                    }
                }
                i++;
                System.out.println();
                print(arr);
                print(visited);
                for(; j >= 0; j--) {
                    if(!visited[j][i]) {
                        arr[j][i] = count++;
                        visited[j][i] = true;
                    }
                }
                j++;
                System.out.println();
                print(arr);
                if(count == num * num) {
                    break;
                }
            }
            System.out.println("#"+t);
        }
    }
    static void print(int[][] arr) {
        for(int l = 0; l < arr.length; l++) {
            System.out.println(Arrays.toString(arr[l]));
        }
    }
    static void print(boolean[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
//    //    public static void main(String[] args) {
//    public d2_1954() {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int t = 1; t <= T; t++) {
//            int N = sc.nextInt();
//            int[][] arr = new int[N][N];
//            System.out.println("#" + t);
//            int x = 0;
//            int y = -1;
//            int k = 1;
//            int l = N;
//            int count = 1;
//            while (true) {
//                if(count > N*N) {
//                    break;
//                }
//                for (int n = 0; n < l; n++) {
//                    y = y + k;
////                    System.out.println("y: "+y);
//                    arr[x][y] = count;
//                    count++;
//                }
//                l--;
//
//                for (int n = 0; n < l; n++) {
//                    x = x + k;
////                    System.out.println("x: "+x);
//                    arr[x][y] = count;
//                    count++;
//                }
//                k = -k ;
//            }
//            print(arr);
//        }
//    }

//    static void print(int[][] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

}
