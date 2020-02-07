package com.swexpertacademy;

import java.util.Scanner;

//안경이 없어
public class d3_7272 {
    static String[] strs = {"CEFGHIJKLMNSTUVWXYZ", "ADOPQR", "B"};
//    public static void main(String[] args) {
    public d3_7272() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            String str1 = sc.next();
            String str2 = sc.next();
            if(str1.length() != str2.length()) {
                System.out.println("#"+t+" DIFF");
                continue;
            }
            if(convert(str1).equals(convert(str2))) {
                System.out.println("#"+t+" SAME");
            }
            else {
                System.out.println("#"+t+" DIFF");
            }
        }
    }
    public String convert(String str) {
        String result = "";
        for(char c : str.toCharArray()) {
            for(int i = 0; i < strs.length; i++) {
                for(int j = 0; j < strs[i].length(); j++) {
                    if(c == strs[i].charAt(j)) {
                        result += i;
                    }
                }
            }
        }
        return result;
    }
}
