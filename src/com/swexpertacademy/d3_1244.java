package com.swexpertacademy;

import java.util.Arrays;
import java.util.*;

//최대상금
public class d3_1244 {
    public static String replace(String str, int start, int end) {
        str = str.replace(str.charAt(start), str.charAt(end));
        return str;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            String str = sc.next();
            int num = sc.nextInt();
            for(int i = 0; i < num; i++) {
                for(int j = 0; j < str.length()-1; j++) {
                    for(int k = j+1; k < str.length(); k++) {
                        char temp = str.charAt(k);
                        str = str.replace(str.charAt(j), str.charAt(k));
                        str = str.replace(temp, str.charAt(j));
                        System.out.println(str);
                    }
                }
            }
            System.out.println();
//            System.out.print("#"+t+" ");
//            for(int i = 0; i < list.size(); i++) {
//                System.out.print(list.get(i));
//            }
//            System.out.println();
        }
    }
}
