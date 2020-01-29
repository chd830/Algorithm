package com.swexpertacademy;

import java.util.Scanner;

//String
public class d3_1213 {
    public d3_1213() {
        Scanner sc = new Scanner(System.in);
        for(int t = 1; t <= 10; t++) {
            int T = sc.nextInt();
            String find = sc.next();
            String str = sc.next();
//            대소문자를 구분해서 받는다.
//            str = str.toLowerCase();
//            find = find.toLowerCase();
            int count = 0;
            for(int i = 0; i < str.length() - find.length() + 1; i++) {
                if(str.substring(i, i+find.length()).equals(find)) {
                    count++;
                }
            }
            System.out.println("#"+t+" "+count);
        }
    }
}
