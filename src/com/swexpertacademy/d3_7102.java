package com.swexpertacademy;

import java.util.Scanner;

//준홍이의 카드놀이
public class d3_7102 {
    public d3_7102() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            if(N == M) {
                System.out.println("#"+t+" "+(N+1));
            }
            else if(N > M) {
                System.out.print("#"+t+" ");
                for(int i = M; i <= N; i++) {
                    System.out.print((i+1)+" ");
                }
            }
            else {
                System.out.print("#"+t+" ");
                for(int i = N; i <= M; i++) {
                    System.out.print((i+1)+" ");
                }
            }
        }
    }
}
