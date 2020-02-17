package com.swexpertacademy;

import java.util.Scanner;

//아바바바
public class d3_8840 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            long L = sc.nextInt();
            System.out.println("#"+t+" "+(L-1)/2 *(L-1)/2);
        }
    }
}
