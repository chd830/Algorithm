package com.swexpertacademy;

import java.util.Scanner;

//시각 덧셈
public class d2_1976 {
//    public static void main(String[] args) {
    public d2_1976() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int[] arr = new int[4];
            for(int i = 0; i < 4; i++) {
                arr[i] = sc.nextInt();
            }
            arr[0] += arr[2];
            arr[1] += arr[3];
            if(arr[1] >= 60) {
                arr[1] -= 60;
                arr[0]++;
            }
            if(arr[0] > 12) {
                arr[0] -= 12;
            }
            System.out.println("#"+t+" "+arr[0]+" "+arr[1]);
        }
    }
}
