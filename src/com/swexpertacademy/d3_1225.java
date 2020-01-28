package com.swexpertacademy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class d3_1225 {
    public d3_1225() {
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= 10; i++) {
            int T = sc.nextInt();
            Queue<Integer> que = new LinkedList<>();
            for(int j = 0; j < 8; j++) {
                int num = sc.nextInt();
                num %= Math.pow(10, (int)Math.log10(num) - 1);
                que.add(num);
            }
            int index = 0;
            boolean check = true;
            while(check) {
                int num = que.poll();
                if(index >= 5) {
                    index = 0;
                    System.out.println();
                }
                num -= (index + 1);
                if(num <= 0) {
                    que.add(0);
                    break;
                }
                que.add(num);
                index++;
                System.out.print(num+" ");
            }
            System.out.println();
            while(!que.isEmpty()) {
                System.out.print(que.poll()+" ");
            }
        }
    }
}
