package com.swexpertacademy;

import java.util.Scanner;

//가랏! RC카!
public class d2_1940 {
    public d2_1940() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        //현재속도유지(0) 가속(1) 감속(2)
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][2];
            int speed = 0;
            int move = 0;
            for(int i = 0; i < N; i++) {
                arr[i][0] = sc.nextInt();
                if(arr[i][0] != 0) {
                    arr[i][1] = sc.nextInt();
                }
                if(arr[i][0] == 1) {
                    speed += arr[i][1];
                }
                else if(arr[i][0] == 2){
                    speed = speed - arr[i][1] > 0 ? speed - arr[i][1] : 0;
                }
                move += speed;
            }
            System.out.println("#"+t+" "+move);
        }
    }
}
