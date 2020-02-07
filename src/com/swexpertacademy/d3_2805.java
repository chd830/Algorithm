package com.swexpertacademy;

import java.util.Scanner;

//농작물 수확하기
public class d3_2805 {
//    public static void main(String[] args) {
    public d3_2805() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            String[] field = new String[N];
            int sum = 0;
            for(int i = 0; i < N; i++) {
                field[i] = sc.next();
            }
            for(int i = 0; i < N; i++) {
                sum += field[N/2].charAt(i) - 48;
            }
            for(int i = 0, k = N-1, j = N/2; i < N/2; i++, j --, k--) {
                for(int l = j; l <= N/2+i; l++) {
//                    System.out.print("("+i+", "+l+")");
                    sum += field[i].charAt(l) - 48;
//                    System.out.print("("+k+", "+l+")");
                    sum += field[k].charAt(l) - 48;
                }
//                System.out.println();
            }
            System.out.println("#"+t+" "+sum);
        }
    }
}
