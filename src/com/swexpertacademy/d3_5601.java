package com.swexpertacademy;

import java.util.Scanner;

//쥬스 나누기
public class d3_5601 {
    public d3_5601() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++) {
            int num = sc.nextInt();
            System.out.print("#"+(t+1)+" ");
            for(int i = 0; i < num; i++) {
                System.out.print("1/"+num+" ");
            }
            System.out.println();
        }
    }
}
