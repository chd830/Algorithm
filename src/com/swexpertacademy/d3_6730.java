package com.swexpertacademy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//장애물 경주 난이도
public class d3_6730 {
    public d3_6730() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int size = sc.nextInt();
            Queue<Integer> que = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                que.add(sc.nextInt());
            }
            int max = 0;
            int min = 0;
            int first = que.poll();
            while(!que.isEmpty()) {
                int cur = que.poll();
                if(max < (cur-first)) {
                    max = cur - first;
                }
                if(min > (cur - first)) {
                    min = cur - first;
                }
                first = cur;
            }
            System.out.println("#" + t + " "+max+" "+Math.abs(min));
        }
    }
}
