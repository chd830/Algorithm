package com.swexpertacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//암호문1
public class d3_1228 {
    public d3_1228() {
        Scanner sc = new Scanner(System.in);
        for(int t = 1; t <= 10; t++) {
            int test = sc.nextInt();
            List<Integer> list = new ArrayList();
            for(int i = 0; i < test; i++) {
                list.add(sc.nextInt());
            }
            int N = sc.nextInt();
            int count = 0;
            while(count < N) {
                String I = sc.next();
                count++;
                int num = sc.nextInt();
                int add = sc.nextInt();
                for(int j = 0; j < add; j++) {
                    list.add(num++, sc.nextInt());
                }
            }
            System.out.print("#"+t+" ");
            for(int i = 0; i < 10; i++) {
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
    }
}
