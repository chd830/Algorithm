package com.swexpertacademy;

import java.util.Scanner;

//원재의 메모리 복구하기
public class d3_1289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            String str = sc.next();
            char[] cur = str.toCharArray();
            char prev = '0';
            int count = 0;
            for(char c : cur) {
                if(prev != c) {
                    count++;
                }
                prev = c;
            }
            System.out.printf("#%cnt %cnt",(i+1), count);
        }
    }
}
