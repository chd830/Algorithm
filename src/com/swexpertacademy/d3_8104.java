package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//조 만들기
public class d3_8104 {
    //    public static void main(String[] args) {
    public d3_8104() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int even = 1;
            int odd = 0;
            int sum = 0;
            if(N == 1) {
                System.out.print("#"+t+" ");
                for(int i= 1; i <= M; i++) {
                    System.out.print(i+" ");
                }
                System.out.println();
                continue;
            }
            for(int i = 0; i < N; i++) {
                if(i == 0) {
//                    System.out.print(even+" ");
                    sum += even;
                }
                else if(i%2 == 0) {
                    even += M*2;
                    sum += even;
//                    System.out.print(even+" ");
                }
                else {
                    odd += M*2;
                    sum += odd;
//                    System.out.print(odd+" ");
                }

//                System.out.println(sum);
            }
            System.out.print("#"+t+" ");
            for(int i = 0; i < M; i++) {
                if(N%2 == 0) {
                    System.out.print(sum++ + " ");
                }
                else {
                    System.out.print(sum+" ");
                }
            }
            System.out.println();
        }
    }
    public static void zigzag() {
        int[][] arr = new int[5][5];
        int val = 1;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                arr[i][j+((4-2*j)*(i%2))] = val++;
            }
        }
        for(int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
