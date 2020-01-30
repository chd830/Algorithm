package com.swexpertacademy;

import java.util.Scanner;

//날짜 계산기
public class d2_1948 {
    //    public static void main(String[] args) {
    public d2_1948() {
        Scanner sc = new Scanner(System.in);
        int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int[] date1 = new int[2];
            int[] date2 = new int[2];
            date1[0] = sc.nextInt();
            date1[1] = sc.nextInt();
            date2[0] = sc.nextInt();
            date2[1] = sc.nextInt();
            if(date1[0] == date2[0]) {
                System.out.println("#" + t + " "+(date2[1] - date1[1] +1));
            }
            else {
                int sum = 0;
                for(int i = date1[0]; i < date2[0]; i++) {
                    sum += day[i];
                }
                sum += date2[1] - date1[1] + 1;
                System.out.println("#"+t+" "+sum);
            }
        }
    }
}
