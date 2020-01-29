package com.swexpertacademy;

import java.util.Scanner;

//거듭제곱
public class d3_1217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++) {
            int T = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println("#"+T+" "+Math.pow(N, M));
        }

    }
}
