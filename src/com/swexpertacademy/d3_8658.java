package com.swexpertacademy;

import java.util.*;

//Summation
public class d3_8658 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int[] arr = new int[10];
            int[] count = new int[10];
            int min = Integer.MAX_VALUE;
            int max = 0;
            for(int i = 0; i < 10; i++) {
                int num = sc.nextInt();
                arr[i] = num;
                while(num >= 10) {
                    count[i] += num % 10;
                    num /= 10;
                }
                count[i] += num;
                if(count[i] > max) {
                    max = count[i];
                }
                if(count[i] < min) {
                    min = count[i];
                }
            }
            System.out.println("#"+t+" "+max+" "+min);
        }
    }
}
