package com.swexpertacademy;

import java.util.Scanner;

//간단한 369게임
public class d2_1926 {
//    public static void main(String[] args) {
    public d2_1926() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 1; i <= N; i++) {
            String str = "" + i;
            boolean isClap = false;
            for(char c : str.toCharArray()) {
                if((c-48) != 0 && (c - 48)%3 == 0) {
                    isClap = true;
                    System.out.print("-");
                }
            }
            if(!isClap) {
                System.out.print(i +" ");
            }
            else {
                System.out.print(" ");
            }
        }
    }
}
