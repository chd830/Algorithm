package com.swexpertacademy;

import java.util.Scanner;

//간단한 소인수분해
public class d2_1945 {
    public d2_1945() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] count = new int[5];
            while(N%2 == 0) {
                N /= 2;
                count[0]++;
            }
            while(N%3 == 0) {
                N /= 3;
                count[1]++;
            }
            while(N%5 == 0) {
                N /= 5;
                count[2]++;
            }
            while(N%7 == 0) {
                N /= 7;
                count[3]++;
            }
            while(N%11 == 0) {
                N /= 11;
                count[4]++;
            }
            System.out.print("#"+t+" ");
            for(int i = 0; i < count.length; i++) {
                System.out.print(count[i]+" ");
            }
            System.out.println();
        }
    }
}
