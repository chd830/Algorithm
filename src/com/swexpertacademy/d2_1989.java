package com.swexpertacademy;

import java.util.Scanner;

//초심자의 회문 검사
public class d2_1989 {
    public d2_1989() {
        Scanner sc = new  Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            StringBuilder sb = new StringBuilder(sc.next());
            if(sb.toString().equals(sb.reverse().toString())) {
                System.out.println("#"+t+" "+1);
            }
            else {
                System.out.println("#"+t+" "+0);
            }
        }
    }
}
