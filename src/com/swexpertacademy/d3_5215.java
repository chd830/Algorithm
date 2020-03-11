package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//햄버거 다이어트
public class d3_5215 {
//    public static void main(String[] args) {
    public d3_5215() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int L = sc.nextInt();
            int[] tastes = new int[N];
            int[] calories = new int[N];
            double[] rate = new double[N];
            int[] rank = new int[N];
            for(int i = 0; i < N; i++) {
                tastes[i] = sc.nextInt();
                calories[i] = sc.nextInt();
                rate[i] = (double)tastes[i] / calories[i];
            }
            for(int i = 0; i < N - 1; i++) {
                for(int j = i + 1; j < N; j++) {
                    if(rate[i] > rate[j]) {
                        double temp = rate[i];
                        rate[i] = rate[j];
                        rate[j] = temp;
                        int tmp = tastes[i];
                        tastes[i] = tastes[j];
                        tastes[j] = tmp;
                        tmp = calories[i];
                        calories[i] = calories[j];
                        calories[j] = tmp;
                    }
                }
            }
            System.out.println(Arrays.toString(rate));
            System.out.println(Arrays.toString(tastes));
            System.out.println(Arrays.toString(calories));
//            int maxTaste = 0;
//            for(int i = 0; i < 1<<W; i++) {
//                int taste = 0;
//                int cal = 0;
//                for(int j = 0; j < W; j++) {
//                    if((i & 1 <<j) != 0) {
//                        taste += tastes[j];
//                        cal += calories[j];
//                    }
//                }
//                if(cal <= L && maxTaste < taste) {
//                    maxTaste = taste;
//                }
//            }
//            System.out.println("#"+t+" "+maxTaste);
        }
    }
}
