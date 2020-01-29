package com.swexpertacademy;

import java.util.Scanner;

//승현이의 수학공부
public class d3_7193 {
    public d3_7193() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int sum = 0;
            String X = sc.next();
            for(int i = X.length() - 1; i >= 0 ; i--) {
                int num = X.charAt(i) - 48;
                sum += num;
            }
            System.out.println("#"+t+" "+sum%(N-1));
        }
    }
}
