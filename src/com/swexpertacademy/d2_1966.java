package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//숫자를 정렬하자
public class d2_1966 {
//    public static void main(String[] args) {
    public d2_1966() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println("#"+t+" "+arr);
        }
    }
}
