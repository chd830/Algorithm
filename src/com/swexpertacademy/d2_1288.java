package com.swexpertacademy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

//새로운 불면증 치료법
public class d2_1288 {
    public d2_1288() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++) {
            HashSet<Integer> set = new HashSet<>();
            int N = sc.nextInt();
            int copy = N;
            int num = 1;
            int count = 0;
            while(set.size() != 10) {
                copy = N * num;
//                System.out.println(num+"N: "+num*N);
                while(copy > 10) {
                    int last = copy % 10;
//                    System.out.print(last+" ");
                    set.add(last);
                    copy /= 10;
                }
//                System.out.println(copy+" ");
                if(copy == 10) {
                    set.add(0);
                    set.add(1);
                }
                else {
                    set.add(copy);
                }
                num++;
                count++;
            }
            System.out.println("#"+(t+1)+" "+(N*(num-1)));
        }
    }
}
