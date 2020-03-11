package com.swexpertacademy;

import java.util.*;

//진기의 최고급 붕어빵
public class d3_1860 {
    //    public static void main(String[] args) {
    public d3_1860() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        testcase: for(int t = 1; t <= T; t++) {
            //N명이 M초의 시간을 들여 만든 K개의 붕어빵
            int num = 0;
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            //2초의 시간으로 2개의 붕어빵을 만듦.
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                //3초와 4초에 붕어빵을 받으러옴.
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
//            for(int i = 0, idx = 0; i <= customer[W-1]; i++) {
//                if(i > 0 && i%H == 0) {
//                    if(i == H || i != 0) {
//                        num += K;
//                    }
//                }
//                if(idx < customer.length && i == customer[idx]) {
//                    if(num != 0) {
//                        num -= 1;
//                        idx++;
//                    }
//                    else {
//                        System.out.println("#"+t+" Impossible");
//                        continue testcase;
//                    }
//                }
//            }
//            System.out.println("#"+t+" Possible");
            boolean flag = true;
            for(int i = 0; i < N; i++) {
                int bread = arr[i] / M * K - i;
                if(bread <= 0) {
                    flag = false;
                    break;
                }
            }
            System.out.println("#"+t+" "+(flag ? "Possible": "Impossible"));
        }
    }
}
