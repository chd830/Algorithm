package com.swexpertacademy;

import java.util.Scanner;

public class 구간합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 32;
        int result = 0;
        for(int i = 0; i <= N; i++) {
            result += i;
        }
        System.out.println(result);
    }
}
