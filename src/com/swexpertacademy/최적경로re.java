package com.swexpertacademy;

import java.util.Scanner;

public class 최적경로re {
    static int N;
    //회사좌표
    static int CX;
    static int CY;
    //집좌표
    static int HX;
    static int HY;
    static int[][] customer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            sum = 0;
            min = Integer.MAX_VALUE;
            N = sc.nextInt();
            CX = sc.nextInt();
            CY = sc.nextInt();
            customer = new int[N][2];
            for(int i = 0; i < customer.length; i++) {
                customer[i][0] = sc.nextInt();
                customer[i][1] = sc.nextInt();
            }
            HX = sc.nextInt();
            HY = sc.nextInt();
            recur(0, 0, CX, CY, 0);
            System.out.println("#"+t+" "+min);
        }
    }
    static int min;
    static int sum;

    static void recur(int count, int visited, int dx, int dy, int result) {
        //가지치기
        if(result >= min) {
            return;
        }
        //기저조건
        if(count == N) {
            result += Math.abs(dx - HX) + Math.abs(dy - HY);
            if(min > result) {
                min = result;
            }
            return;
        }
        for(int i = 0; i < N; i++) {
            if((visited & 1<<i) == 0) {
                recur(count+1, visited | (1<<i), customer[i][0], customer[i][1], result + Math.abs(dx - customer[i][0]) + Math.abs(dy - customer[i][1]));
            }
        }
    }
}
