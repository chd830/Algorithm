package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//Flatten
public class d3_1208 {
//    public static void main(String[] args) {
    public d3_1208() {
        Scanner sc = new Scanner(System.in);
        for(int t = 1; t <= 10; t++) {
            int[] arr = new int[100];
            int num = sc.nextInt();
            for(int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt();
            }
            int start = 0;
            int end = 99;
            while(num > 0) {
                Arrays.sort(arr);
                if(arr[end] - arr[start] > 1) {
//                    System.out.println(arr[start]+" "+arr[end]);
                    arr[end]--;
                    arr[start]++;
                    num--;
                    continue;
                }
                if(arr[end] - arr[start] <= 1) {
//                    System.out.println(arr[start]+" "+arr[end]);
                    start++;
                    end--;
                }
            }
            Arrays.sort(arr);
            System.out.println("#"+t+" "+(arr[99]-arr[0]));
        }
    }
}
