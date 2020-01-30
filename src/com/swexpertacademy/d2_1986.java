package com.swexpertacademy;

import java.util.Scanner;

//지그재그 숫자
public class d2_1986 {
    public d2_1986() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int result = 0;
            for(int i = 1; i <= N; i++) {
                if(i % 2 == 1) {
                    result += i;
                }
                else {
                    result -= i;
                }
            }
            System.out.println("#"+t+" "+result);
        }
    }
}
