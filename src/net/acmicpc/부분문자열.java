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
    static int[] getPi(String str) {
        int[] pi = new int[str.length()];
        int j = 0;
        for(int i = 1; i < str.length(); i++) {
            //두 값이 일치할 때 이전까지 모두 같은 값을 가진거이므로 j값 증가 후 배열에 값넣음.
            if(str.charAt(i) == str.charAt(j)) {
                pi[i] = ++j;
            }
            //두 값이 다르면 pi에서 j-1의 값을 가져온다.
            else {
                while(j > 0 && str.charAt(i) != str.charAt(j)) {
                    j = pi[j-1];
                }
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
