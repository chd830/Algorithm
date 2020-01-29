package com.swexpertacademy;

import java.util.Scanner;

//다솔이의 다이아몬드 장식
public class d3_4751 {
    public d3_4751() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            String str = sc.next();
            String copy = "";
            for(char c : str.toCharArray()) {
                copy +=".";
                copy += c + ".#";
            }
            for(int i = 0; i < 5; i++) {
                switch(i) {
                    case 0:
                    case 4:
                        System.out.print(".");
                        for(int j = 0; j < copy.length()/4; j++) {
                            System.out.print(".#..");
                        }
                        System.out.println();
                        break;
                    case 1:
                    case 3:
                        System.out.print(".");
                        for(int j = 0; j < (copy.length()+2)/2 - 1; j++) {
                            System.out.print("#.");
                        }
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("#"+copy);
                        break;
                }
            }
        }
    }
}
