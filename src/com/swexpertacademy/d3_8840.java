package com.swexpertacademy;

import java.util.Scanner;

//아바바바
public class d3_8840 {
    static String str;
    static String[] strs;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int L = sc.nextInt();
            str = "";
            for(int i = 0; i < L; i++) {
                if(i%2 == 0) {
                    str += "a";
                }
                else {
                    str += "b";
                }
            }
            System.out.println(str);
            for(int i = 0; i < str.length() - 1; i++) {
                for(int j = str.length(); j > i; j--) {

                }
            }
//            System.out.println("#"+t+" ");
        }
    }
}
