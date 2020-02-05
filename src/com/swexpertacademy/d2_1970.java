package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//쉬운 거스름돈
public class d2_1970 {
//    public static void main(String[] args) {
    public d2_1970() {
        int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] result = new int[8];
            for(int i = 0; i < arr.length; i++) {
                if(N / arr[i] > 0) {
                    result[i] = N / arr[i];
                    N %= arr[i];
                }
            }
            System.out.println("#"+t+" ");
            for(int r : result)
                System.out.print(r+" ");
            System.out.println();
        }
    }
}
