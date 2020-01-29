package com.swexpertacademy;

import java.util.Scanner;

//동철이의 프로그래밍 대회
public class d3_6913 {
    public d3_6913() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] arr = new int[N];
            int max = 0;
            int count = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    int num = sc.nextInt();
                    if(num == 1) {
                        arr[i] += 1;
                    }
                }
                if(arr[i] > max) {
                    max = arr[i];
                }
            }
            for(int i = 0; i < N; i++) {
                if(arr[i] == max) {
                    count++;
                }
            }
            System.out.println("#"+t+" "+count+" "+max);
        }
    }
}
