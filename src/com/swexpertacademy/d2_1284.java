package com.swexpertacademy;

import java.util.Scanner;

//수도 요금 경쟁
public class d2_1284 {
    public d2_1284() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] arr = new int[T][5];
        for(int t = 0; t < T; t++) {
            for(int i = 0; i < 5; i++) {
                arr[t][i] = sc.nextInt();
            }
            if(arr[t][4] <= arr[t][2]) {
                if(arr[t][1] < arr[t][0] * arr[t][4]) {
                    System.out.println("#"+(t+1)+" "+arr[t][1]);
                    continue;
                }
                else {
                    System.out.println("#"+(t+1)+" "+arr[t][0] * arr[t][4]);
                    continue;
                }
            }
            else {
                if((arr[t][1] + (arr[t][3] * (arr[t][4] - arr[t][2]))) < arr[t][0] * arr[t][4]) {
                    System.out.println("#"+(t+1)+" "+(arr[t][1] + (arr[t][3] * (arr[t][4] - arr[t][2]))));
                    continue;
                }
                else {
                    System.out.println("#"+(t+1)+" "+arr[t][0] * arr[t][4]);
                    continue;
                }
            }
        }
    }
}
