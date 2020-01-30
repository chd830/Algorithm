package com.swexpertacademy;

import java.util.Scanner;

//패턴 마디의 길이
public class d2_2007 {
//    public static void main(String[] args) {
    public d2_2007() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            String str = sc.next();
            for(int i = 1; i < str.length(); i++) {
                if(str.substring(0, i).equals(str.substring(i, i+i))) {
                    System.out.println("#"+t+" "+i);
                    break;
                }
            }
        }
    }
}
