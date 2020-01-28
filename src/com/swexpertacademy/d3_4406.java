package com.swexpertacademy;

import java.util.Scanner;

public class d3_4406 {
    public d3_4406() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            String str = sc.next();
            String result = "";
            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    continue;
                }
                result += c;
            }
            System.out.println("#"+(i+1)+" "+result);
        }
    }
    public static void main(String[] args) {

    }
}