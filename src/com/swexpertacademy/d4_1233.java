package com.swexpertacademy;

import java.util.*;

//사칙연산 유효성 검사
public class d4_1233 {
    static Stack<Double> stack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int size = sc.nextInt();
            int[][] node = new int[size / 2 + 1][2];
            Tree tree = new Tree(200);
            stack = new Stack<Double>();
            int left = 0;
            int right = 0;
            for (int i = 1, idx = 0; i <= size; i++) {
                int num = sc.nextInt();
                char c = sc.next().charAt(0);
                boolean flag = true;
                for (int j = 0; j <= idx; j++) {
                    if (num == node[j][0]) {
                        tree.setLeft(c, node[j][0] / 2);
                        flag = false;
                    } else if (num == node[j][1]) {
                        flag = false;
                        tree.setRight(c, (node[j][1] / 2) + 1);
                    }
                }
                if (flag) {
                    tree.set(c, num);
                }
                if (i <= size / 2) {
                    left = sc.nextInt();
                    node[idx][0] = left;
                    if (left == size) {
                        continue;
                    }
                    right = sc.nextInt();
                    node[idx][1] = right;
                    if (right == size) {
                        continue;
                    }
                    idx++;
                }
            }
            tree.backorder(1);
            System.out.println();
//            if(tree.check) {
//                System.out.println("#"+t+" 1");
//            }
//            else {
//                System.out.println("#"+t+" 0");
//            }
        }
    }
}