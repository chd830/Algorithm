package com.swexpertacademy;

import java.util.Scanner;

//달팽이 숫자
public class d2_1954 {
    //    public static void main(String[] args) {
    public d2_1954() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            System.out.println("#" + t);
            int x = 0;
            int y = -1;
            int k = 1;
            int l = N;
            int count = 1;
            while (true) {
                if(count > N*N) {
                    break;
                }
                for (int n = 0; n < l; n++) {
                    y = y + k;
//                    System.out.println("y: "+y);
                    arr[x][y] = count;
                    count++;
                }
                l--;

                for (int n = 0; n < l; n++) {
                    x = x + k;
//                    System.out.println("x: "+x);
                    arr[x][y] = count;
                    count++;
                }
                k = -k ;
            }
            print(arr);
        }
    }

    static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
