package net.acmicpc;

import java.util.Scanner;

public class 부분문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(); //기준
        String p = sc.next(); //sub
        if(s.equals(p) || KMP(p, s))
            System.out.println("1");
        else
            System.out.println("0");
    }
    static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];
        int j = 0;
        for(int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
    static boolean KMP(String sub, String origin) {
        int[] pi = getPi(sub);
        int j = 0;
        for(int i = 0; i < origin.length(); i++) {
            while(j > 0 && origin.charAt(i) != sub.charAt(j)) {
                j = pi[j-1];
            }
            if(origin.charAt(i) == sub.charAt(j)) {
                if(j == sub.length()-1) {
                    return true;
                }
                else {
                    j++;
                }
            }
        }
        return false;
    }
}
