package com.swexpertacademy;

import java.util.Scanner;

//모음이 보이지 않는 사람
public class d3_4406 {
    public d3_4406() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t < T; t++) {
            String str = sc.next();
            String result = "";
            System.out.print("#" + t + " ");
            char c = ' ';
            for (int j = 0; j < str.length(); j++) {
                c = str.charAt(j);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    c = ' ';
                    continue;
                }
                System.out.print(c);
            }
            System.out.println();
        }
    }
}